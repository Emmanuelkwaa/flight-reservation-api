package com.skillstorm.flightreservationapi.services.implementation;

import com.skillstorm.flightreservationapi.data.repositories.FlightRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.models.Flight;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FlightService extends GenericRepositoryImpl<Flight, Integer> implements FlightServiceInterface {
    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        super(flightRepository);
        this.flightRepository = flightRepository;
    }

    public List<Flight> findByCity(String departAirportCity, String arrivalAirportCity, Date departAirportDate) {
        List<Flight> flights = flightRepository.findFlightsByCity(departAirportCity, arrivalAirportCity, departAirportDate);
        if(flights.isEmpty()) {
            return null;
        }

        return flights;
    }
}
