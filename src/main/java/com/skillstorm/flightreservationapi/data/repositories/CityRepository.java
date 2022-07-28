package com.skillstorm.flightreservationapi.data.repositories;

import org.springframework.stereotype.Repository;

import com.skillstorm.flightreservationapi.models.City;
import com.skillstorm.flightreservationapi.models.Flight;

@Repository
public interface CityRepository extends GenericRepository<City, Integer> {
}


