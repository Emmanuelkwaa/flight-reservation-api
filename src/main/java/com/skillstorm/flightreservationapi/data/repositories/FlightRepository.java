package com.skillstorm.flightreservationapi.data.repositories;

import com.skillstorm.flightreservationapi.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends GenericRepository<Flight, Integer> {
}
