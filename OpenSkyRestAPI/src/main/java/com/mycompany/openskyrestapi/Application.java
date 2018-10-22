package com.mycompany.openskyrestapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private EntityManagerFactory emf = null;
    private EntityManager entityManager = null;
    private EntityTransaction transaction = null;
    
    public static void main (String[] args) {
        SpringApplication.run(Application.class);        
    }
    
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }    
    
    @Bean
    public CommandLineRunner run (RestTemplate restTemplate) throws Exception {
        return args -> {
            Time tempo = restTemplate.getForObject("https://opensky-network.org/api/states/all", Time.class);
            String url = "https://opensky-network.org/api/flights/all?begin="+tempo.getTempo()+"&end="+tempo.getTempo();
            Flight[] voos = restTemplate.getForObject("https://opensky-network.org/api/flights/all?begin=1540036800&end=1540040400", Flight[].class);
            //log.info(String.valueOf(tempo.getTempo()));
            //for (Flight voo: voos) {
            //    log.info(voo.toString());
            //}
            for (Flight voo: voos) {
                try {
                    emf = Persistence.createEntityManagerFactory("jbd-pu");
                    entityManager = emf.createEntityManager();
                    transaction = entityManager.getTransaction();
                    transaction.begin();
                    entityManager.persist(voo);
                    transaction.commit();                
                } catch (Exception e) {
                    transaction.rollback();
                } finally {
                    entityManager.close();
                    emf.close();
                }
            }

        };
    }
    
    
}
