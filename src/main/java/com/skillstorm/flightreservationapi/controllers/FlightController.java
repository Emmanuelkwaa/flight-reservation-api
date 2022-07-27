package com.skillstorm.flightreservationapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*") //accessible by all
@RequestMapping(path = "/api/flight") // You can do something like "api/v1/pets"
public class FlightController {

}
