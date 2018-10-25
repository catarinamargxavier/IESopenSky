package com.mycompany.openskyrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    //private static final Logger log = LoggerFactory.getLogger(Application.class);
     
    public static void main (String[] args) {
        SpringApplication.run(Application.class);       
    }
  
}
