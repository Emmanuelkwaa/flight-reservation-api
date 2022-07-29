package com.skillstorm.flightreservationapi.data.repositories;

import org.springframework.stereotype.Repository;

import com.skillstorm.flightreservationapi.models.Seat;

@Repository
public interface SeatRepository extends GenericRepository<Seat, Integer> {

}
