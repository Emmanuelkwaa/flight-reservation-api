package com.skillstorm.flightreservationapi.services.implementation;

import com.skillstorm.flightreservationapi.data.repositories.FlightRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.models.Flight;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class FlightService extends GenericRepositoryImpl<Flight, Integer> implements FlightServiceInterface {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        super(flightRepository);
    }
}
