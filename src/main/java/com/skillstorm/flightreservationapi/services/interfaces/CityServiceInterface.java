package com.skillstorm.flightreservationapi.services.interfaces;

import com.skillstorm.flightreservationapi.models.City;

public interface CityServiceInterface  extends GenericService<City, Integer> {

	  City findCityByName(String name);
}
