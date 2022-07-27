package com.skillstorm.flightreservationapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.flightreservationapi.models.Flight;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/flights")
public class FlightController {


	@GetMapping("/{id")
	public Flight findById(@PathVariable int id) {
		return new Flight();
	}
	
	@PostMapping("/{id}")
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
