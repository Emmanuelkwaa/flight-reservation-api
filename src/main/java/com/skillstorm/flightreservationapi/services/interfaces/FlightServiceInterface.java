package com.skillstorm.flightreservationapi.services.interfaces;

import com.skillstorm.flightreservationapi.models.Flight;

import java.util.Date;
import java.util.List;

public interface FlightServiceInterface extends GenericService<Flight, Integer> {
    List<Flight> findByCity(String departAirportCity, String arrivalAirportCity, Date departAirportDate);
}
