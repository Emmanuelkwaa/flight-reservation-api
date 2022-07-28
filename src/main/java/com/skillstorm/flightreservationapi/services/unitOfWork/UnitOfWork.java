package com.skillstorm.flightreservationapi.services.unitOfWork;

import com.skillstorm.flightreservationapi.data.repositories.FlightRepository;
import com.skillstorm.flightreservationapi.services.implementation.FlightService;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UnitOfWork implements IUnitOfWork {
    private FlightServiceInterface flightService;

    public UnitOfWork(FlightRepository flightRepository) {
        this.flightService = new FlightService(flightRepository);
    }

    @Override
    public FlightServiceInterface flight() {
        return flightService;
    }
}
