package com.skillstorm.flightreservationapi.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillstorm.flightreservationapi.models.Ticket;

@RequestMapping("api/v1/tickets")
public class TicketController {

	@GetMapping("/{id")
	public Ticket findById(@PathVariable int id) {
		return new Ticket();
	}
	
	@PostMapping("/{id}")
	public Ticket createTicket(@PathVariable int id) {
		return new Ticket(); 
	}
	
	@PutMapping("/{id}") 
	public Ticket updateTicket(@PathVariable int id) {
		return new Ticket();
	}
	
	@DeleteMapping("/{id}")
	public void deleteTicket(@PathVariable int id) {
		
	}
}
