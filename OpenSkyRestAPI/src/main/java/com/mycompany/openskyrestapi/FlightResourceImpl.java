package com.mycompany.openskyrestapi;

import com.mycompany.openskyrestapi.repository.RepositoryFlightsByTime;
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
    
}
