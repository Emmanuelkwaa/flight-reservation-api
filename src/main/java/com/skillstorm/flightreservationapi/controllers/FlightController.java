package com.skillstorm.flightreservationapi.controllers;

import com.skillstorm.flightreservationapi.services.implementation.FlightService;
import com.skillstorm.flightreservationapi.services.unitOfWork.IUnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.flightreservationapi.models.Flight;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/flights")
public class FlightController {
	private final IUnitOfWork unitOfWork;
	private final FlightService flightService;

	@Autowired
	public FlightController(IUnitOfWork unitOfWork, FlightService flightService) {
		this.unitOfWork = unitOfWork;
		this.flightService = flightService;
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
