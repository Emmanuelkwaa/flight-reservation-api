package com.skillstorm.flightreservationapi.services.unitOfWork;

import com.skillstorm.flightreservationapi.data.repositories.AirportRepository;
import com.skillstorm.flightreservationapi.data.repositories.CityRepository;
import com.skillstorm.flightreservationapi.data.repositories.FlightRepository;
import com.skillstorm.flightreservationapi.services.implementation.AirportService;
import com.skillstorm.flightreservationapi.services.implementation.CityService;
import com.skillstorm.flightreservationapi.services.implementation.FlightService;
import com.skillstorm.flightreservationapi.services.interfaces.AirportServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.CityServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UnitOfWork implements IUnitOfWork {
    private FlightServiceInterface flightService;
    private CityServiceInterface cityService;
    private AirportServiceInterface airportService;
    
    public UnitOfWork(FlightRepository flightRepository,
    		CityRepository cityRepository, AirportRepository airportRepository) {
        this.flightService = new FlightService(flightRepository);
        this.cityService = new CityService(cityRepository);
        this.airportService = new AirportService(airportRepository);
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
}
