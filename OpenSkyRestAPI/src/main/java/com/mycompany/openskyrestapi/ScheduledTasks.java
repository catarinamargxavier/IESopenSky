package com.mycompany.openskyrestapi;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    
    @Autowired
    private FlightService service;

    @Scheduled(fixedRate = 2500)
    public void reportCurrentTime() throws Exception {
        run(new RestTemplate());
    }
    
    
    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder) {
        return builder.build();
    }    
    
    //@Bean
    public void run (RestTemplate restTemplate) throws Exception{
        //log.info("RUNNING AGAIN");
        int tempo = (int) (new Date().getTime()/1000);
        tempo = tempo - 10000;
        String url = "https://opensky-network.org/api/flights/all?begin="+tempo+"&end="+tempo;
        Flight[] voos = restTemplate.getForObject(url, Flight[].class);
        for (Flight voo: voos) {
            FlightsByTime novo = service.creatFlight(new FlightsByTime(tempo,voo));
        }
    }
  
}
