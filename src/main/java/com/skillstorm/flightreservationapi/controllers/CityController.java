package com.skillstorm.flightreservationapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.flightreservationapi.models.City;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/cities")
public class CityController {
	
	@GetMapping("/{id")
	public City findById(@PathVariable int id) {
		return new City();
	}
	
	@PostMapping("/{id}")
	public City createCity(@PathVariable int id) {
		return new City(); 
	}
	
	@PutMapping("/{id}") 
	public City updateCity(@PathVariable int id) {
		return new City();
	}
	
	@DeleteMapping("/{id}")
	public void deleteCity(@PathVariable int id) {
		
	}

}
