package com.skillstorm.flightreservationapi.controllers;

import com.skillstorm.flightreservationapi.models.Booking;
import com.skillstorm.flightreservationapi.services.implementation.FlightService;
import com.skillstorm.flightreservationapi.services.unitOfWork.IUnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.flightreservationapi.models.Flight;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/flights")
public class FlightController {
	private final IUnitOfWork unitOfWork;

	@Autowired
	public FlightController(IUnitOfWork unitOfWork) {
		this.unitOfWork = unitOfWork;
	}

	@GetMapping
	public List<Flight> getAllFlights() {
		return unitOfWork.flight().findAll();
	}

	@GetMapping("/{id}")
	public Optional<Flight> getFlightById(@PathVariable int id) {
		Optional<Flight> flight = unitOfWork.flight().findById(id);
		return flight;
	}

	@PostMapping("/flightByCities")
	public List<Flight> getFlightByDepartAndArriveCity(@RequestBody Booking bookingDetails) {
		return unitOfWork.flight().findByCity(bookingDetails.getDepartCity(), bookingDetails.getArrivalCity(), bookingDetails.getDate());
	}
	
	@PostMapping
	public Flight createFlight(@PathVariable int id) {
		return new Flight(); 
	}
	
	@PutMapping("/{id}") 
	public Flight updateFlight(@PathVariable int id) {
		return new Flight();
	}
	
	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable int id) {
		
	}
}
