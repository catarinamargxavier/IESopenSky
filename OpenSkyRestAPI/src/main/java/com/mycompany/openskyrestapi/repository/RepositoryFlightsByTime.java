package com.mycompany.openskyrestapi.repository;

import com.mycompany.openskyrestapi.FlightsByTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFlightsByTime extends JpaRepository<FlightsByTime,Long> {
    
}
