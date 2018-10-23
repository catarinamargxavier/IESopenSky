package com.mycompany.openskyrestapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name="P201_Time")
public class FlightByTime implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="TIME")
    private int time;
    
    @Embedded
    private Flight voo;
    
    public FlightByTime(int time, Flight voo) {
        this.time = time;
        this.voo = voo;
    }
    
    public FlightByTime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Flight getVoo() {
        return voo;
    }

    public void setVoo(Flight voo) {
        this.voo = voo;
    }
    
    
    
}
