package com.mycompany.openskyrestapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightResourceImpl implements FlightResource {
    
    @Autowired
    private RepositoryFlightsByTime repository;

    @Override
    @GetMapping("/flights")
    public List<FlightByTime> retrieveAllFlights() {
        return repository.findAll();
    }

    @Override
    @GetMapping("/flights/{airline}")
    public List<FlightByTime> retrieveByAirline(@PathVariable String airline) {
        return repository.findByAirline(airline);
    }

    @Override
    @GetMapping("/flights/{airline}/{beginData}/{endData}")
    public List<FlightByTime> retrieveByAirlineAndDate(@PathVariable String airline, @PathVariable int beginData, @PathVariable int endData) {
        return repository.findbyAirlineDate(airline, beginData, endData);
    }
    
    
    
}
