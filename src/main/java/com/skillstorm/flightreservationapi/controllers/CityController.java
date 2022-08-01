package com.skillstorm.flightreservationapi.controllers;

import com.skillstorm.flightreservationapi.services.interfaces.CityServiceInterface;
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

import com.skillstorm.flightreservationapi.models.City;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/cities")
public class CityController {
	private final CityServiceInterface cityService;
	private final IUnitOfWork unitOfWork;

	@Autowired
	public CityController(CityServiceInterface cityService, IUnitOfWork unitOfWork) {
		this.cityService = cityService;
		this.unitOfWork = unitOfWork;
	}

	@GetMapping
	public List<City> getAllCities() {
		return unitOfWork.city().findAll();
	}

	@GetMapping("/{name}")
	public City findCityByName(@PathVariable String name) {
		System.out.println("finding city name");
		City city = unitOfWork.city().findCityByName(name);
		return city;
	}

//	@GetMapping("/{id}")
//	public City findById(@PathVariable int id) {
//		return new City();
//	}
//
//	@PostMapping("/{id}")
//	public City createCity(@PathVariable int id) {
//		return new City();
//	}
//
//	@PutMapping("/{id}")
//	public City updateCity(@PathVariable int id) {
//		return new City();
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteCity(@PathVariable int id) {
//
//	}

}
