package com.skillstorm.flightreservationapi.data.repositories;

import com.skillstorm.flightreservationapi.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends GenericRepository<Flight, Integer> {

    @Query("select f from Flight f where f.departAirport.city.name = ?1 and f.arrivalAirport.city.name = ?2") // todo try to add date to search filter
    List<Flight> findFlightsByCity(String departAirportCity, String arrivalAirportCity, Date departDate);
}
