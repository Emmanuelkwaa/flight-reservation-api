package com.skillstorm.flightreservationapi.services.implementation;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skillstorm.flightreservationapi.data.repositories.CityRepository;
import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.models.City;
import com.skillstorm.flightreservationapi.models.Flight;
import com.skillstorm.flightreservationapi.services.interfaces.CityServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;

@Service
@Transactional
public class CityService extends GenericRepositoryImpl<City, Integer> implements CityServiceInterface {
	private CityRepository cityrepository;
	
	public CityService(CityRepository cityRepository) {
		super(cityRepository);
	}

}
