package com.skillstorm.flightreservationapi.services.implementation;

import com.skillstorm.flightreservationapi.data.repositories.AirportRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.models.Airport;
import com.skillstorm.flightreservationapi.services.interfaces.AirportServiceInterface;


public class AirportService extends GenericRepositoryImpl<Airport, Integer> implements AirportServiceInterface {
	private AirportRepository airportRepositroy;
	
	public AirportService(AirportRepository airportRepository) {
		super(airportRepository);
	}
}
