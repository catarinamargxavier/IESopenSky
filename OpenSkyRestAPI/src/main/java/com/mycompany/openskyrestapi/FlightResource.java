package com.mycompany.openskyrestapi;

import java.util.List;

public interface FlightResource {
    
    List<FlightByTime> retrieveAllFlights();
    List<FlightByTime> retrieveByAirline(String name);
    List<FlightByTime> retrieveByAirlineAndDate(String name, int beginData, int endData);
     
}
