package com.skillstorm.flightreservationapi.data.repositories;

import org.springframework.stereotype.Repository;

import com.skillstorm.flightreservationapi.models.Airport;


@Repository
public interface AirportRepository extends GenericRepository<Airport, Integer> {

}
