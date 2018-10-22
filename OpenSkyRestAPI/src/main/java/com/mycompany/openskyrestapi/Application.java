package com.mycompany.openskyrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);
   
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
            Time tempo = restTemplate.getForObject("https://opensky-network.org/api/flights/states/all", Time.class);
            String url = "https://opensky-network.org/api/flights/all?begin="+tempo.getTempo()+"&end="+tempo.getTempo();
            Flight[] voos = restTemplate.getForObject("https://opensky-network.org/api/flights/all?begin=1540036800&end=1540040400", Flight[].class);
            for (Flight voo: voos) {
                log.info(voo.toString());
            }
        };
    }
    
    
}
