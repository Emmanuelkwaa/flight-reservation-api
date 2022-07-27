package com.skillstorm.flightreservationapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.flightreservationapi.models.Seat;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/seats")
public class SeatController {
	
	@GetMapping("/{id")
	public Seat findById(@PathVariable int id) {
		return new Seat();
	}
	
	@PostMapping("/{id}")
	public Seat createSeat(@PathVariable int id) {
		return new Seat(); 
	}
	
	@PutMapping("/{id}") 
	public Seat updateSeat(@PathVariable int id) {
		return new Seat();
	}
	
	@DeleteMapping("/{id}")
	public void deleteSeat(@PathVariable int id) {
		
	}
}
