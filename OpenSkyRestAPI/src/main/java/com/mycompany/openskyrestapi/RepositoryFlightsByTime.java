package com.mycompany.openskyrestapi;

import com.mycompany.openskyrestapi.FlightByTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFlightsByTime extends JpaRepository<FlightByTime,Long> {
           
    @Query(value = "SELECT * FROM p201_time flight WHERE flight.call_sign LIKE :airline%", nativeQuery = true)
    List <FlightByTime> findByAirline(@Param("airline") String airline);
    
    @Query(value = "SELECT * FROM p201_time flight WHERE flight.call_sign LIKE :airline% AND flight.time BETWEEN :beginData AND :endData", nativeQuery = true)
    List<FlightByTime> findbyAirlineDate(@Param("airline") String airline, @Param("beginData") int beginData, @Param("endData") int endData);
    
}
