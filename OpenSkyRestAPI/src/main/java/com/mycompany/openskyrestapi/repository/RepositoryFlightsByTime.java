package com.mycompany.openskyrestapi.repository;

import com.mycompany.openskyrestapi.FlightByTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFlightsByTime extends JpaRepository<FlightByTime,Long> {
    
}
