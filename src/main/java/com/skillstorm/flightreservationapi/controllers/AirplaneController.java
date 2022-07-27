package com.skillstorm.flightreservationapi.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.flightreservationapi.models.Airplane;


@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/airplanes")
public class AirplaneController {
	
	@GetMapping("/{id")
	public Airplane findById(@PathVariable int id) {
		return new Airplane();
	}
	
	@PostMapping("/{id}")
	public Airplane createAirplane(@PathVariable int id) {
		return new Airplane(); 
	}
	
	@PutMapping("/{id}") 
	public Airplane updateAirplane(@PathVariable int id) {
		return new Airplane();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAirplane(@PathVariable int id) {
		
	}
}
