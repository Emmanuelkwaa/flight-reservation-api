package com.skillstorm.flightreservationapi.data.repositories;

import com.skillstorm.flightreservationapi.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends GenericRepository<Flight, Integer> {
    List<Flight> findByDepartAirport_CityAndArrivalAirport_City(String departAirportCity, String arrivalAirportCity);
}
