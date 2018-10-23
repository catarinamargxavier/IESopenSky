package com.mycompany.openskyrestapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    @Autowired
    private FlightService service;
    
    public static void main (String[] args) {
        SpringApplication.run(Application.class);        
    }
    
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }    
    
    @Bean
    public CommandLineRunner run (RestTemplate restTemplate) throws Exception {
        return (String[] args) -> {
            ActualTime tempo = restTemplate.getForObject("https://opensky-network.org/api/states/all", ActualTime.class);
            //String url = "https://opensky-network.org/api/flights/all?begin="+tempo.getTempo()+"&end="+tempo.getTempo();
            //Flight[] voos = restTemplate.getForObject(url, Flight[].class);
            log.info(tempo.toString());
            //for (Flight voo: voos) {
            //    FlightsByTime novo = service.creatFlight(new FlightsByTime(tempo.getTempo(),voo));
                //log.info(voo.toString());
            //}
        };
    }   
    
}
