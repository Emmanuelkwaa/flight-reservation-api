package com.skillstorm.flightreservationapi.services.implementation;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.data.repositories.SeatRepository;
import com.skillstorm.flightreservationapi.models.Seat;
import com.skillstorm.flightreservationapi.services.interfaces.SeatServiceInterface;

@Service
@Transactional
public class SeatService extends GenericRepositoryImpl<Seat, Integer> implements SeatServiceInterface {
	private SeatRepository seatRepository;
	
	public SeatService(SeatRepository seatRepository) {
		super(seatRepository);
	}
}
