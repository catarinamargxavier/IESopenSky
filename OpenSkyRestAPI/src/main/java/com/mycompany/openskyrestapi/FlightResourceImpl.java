package com.mycompany.openskyrestapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Path("/flights")
@RestController
public class FlightResourceImpl implements FlightResource {
    
    @Autowired
    private RepositoryFlightsByTime repository;

    @Override
    @GetMapping("/flights")
    //@GET
    //@Produces("application/json")
    public List<FlightByTime> retrieveAllFlights() {
        return repository.findAll();
    }

    @Override
    //@GET
    //@Produces("application/json")
    //@Path("/{airline}")
    @GetMapping("/flights/{airline}")
    public List<FlightByTime> retrieveByAirline(@PathVariable String airline) {
        return repository.findByAirline(airline);
    }

    @Override
    //@GET
    //@Produces("application/json")
    //@Path("/{airline}/{beginData}/{endData}")
    @GetMapping("/flights/{airline}/{beginData}/{endData}")
    public List<FlightByTime> retrieveByAirlineAndDate(@PathVariable String airline, @PathVariable int beginData, @PathVariable int endData) {
        return repository.findbyAirlineDate(airline, beginData, endData);
    }
    
    
    
}
