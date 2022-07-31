package com.skillstorm.flightreservationapi.services.implementation;

import com.skillstorm.flightreservationapi.data.repositories.FlightRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.models.Flight;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightService extends GenericRepositoryImpl<Flight, Integer> implements FlightServiceInterface {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        super(flightRepository);
    }

    public List<Flight> findByCities(String departAirportCity, String arrivalAirportCity) {
        return flightRepository.findByDepartAirport_CityAndArrivalAirport_City(departAirportCity, arrivalAirportCity);
    }
}
