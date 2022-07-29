package com.skillstorm.flightreservationapi.services.unitOfWork;

import com.skillstorm.flightreservationapi.data.repositories.AirportRepository;
import com.skillstorm.flightreservationapi.data.repositories.CityRepository;
import com.skillstorm.flightreservationapi.data.repositories.FlightRepository;
import com.skillstorm.flightreservationapi.data.repositories.TicketRepository;
import com.skillstorm.flightreservationapi.data.repositories.UserRepository;
import com.skillstorm.flightreservationapi.services.implementation.AirportService;
import com.skillstorm.flightreservationapi.services.implementation.CityService;
import com.skillstorm.flightreservationapi.services.implementation.FlightService;
import com.skillstorm.flightreservationapi.services.implementation.UserService;
import com.skillstorm.flightreservationapi.services.interfaces.AirportServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.CityServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.UserServiceInterface;

import org.springframework.stereotype.Service;

@Service
public class UnitOfWork implements IUnitOfWork {
    private FlightServiceInterface flightService;
    private CityServiceInterface cityService;
    private AirportServiceInterface airportService;
    private UserServiceInterface userService;
    private TicketServiceInterface ticketService;
    
    public UnitOfWork(FlightRepository flightRepository,
    		CityRepository cityRepository, AirportRepository airportRepository, 
    		UserRepository userRepository, TicketRepository ticketRepository) {
        this.flightService = new FlightService(flightRepository);
        this.cityService = new CityService(cityRepository);
        this.airportService = new AirportService(airportRepository);
        this.userService = new UserService(userRepository);
    }
    
   

    @Override
    public FlightServiceInterface flight() {
        return flightService;
    }

	@Override
	public CityServiceInterface city() {
		return cityService;
	}



	@Override
	public AirportServiceInterface airport() {
		return airportService;
	}



	@Override
	public UserServiceInterface user() {
		return userService;
	}



	@Override
	public TicketServiceInterface ticket() {
		return ticketService;
	}
}
