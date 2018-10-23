package com.mycompany.openskyrestapi;

import com.mycompany.openskyrestapi.repository.RepositoryFlightsByTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private RepositoryFlightsByTime repository;
    
    @Override
    public FlightsByTime creatFlight(FlightsByTime flight) {
        return repository.save(flight);
    }
    
}
