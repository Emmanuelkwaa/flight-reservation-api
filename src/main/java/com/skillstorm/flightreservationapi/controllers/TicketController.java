package com.skillstorm.flightreservationapi.controllers;

import com.skillstorm.flightreservationapi.services.unitOfWork.IUnitOfWork;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.flightreservationapi.models.Ticket;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/tickets")
public class TicketController {

	private final IUnitOfWork unitOfWork;

	public TicketController(IUnitOfWork unitOfWork) {
		this.unitOfWork = unitOfWork;
	}

	@GetMapping("/{id}")
	public Ticket findById(@PathVariable int id) {
		return new Ticket();
	}
	
	@PostMapping
	public Ticket createTicket(@RequestBody Ticket ticket) {

		return this.unitOfWork.ticket().save(ticket);
	}
	
	@PutMapping("/{id}") 
	public Ticket updateTicket(@PathVariable int id) {
		return new Ticket();
	}
	
	@DeleteMapping("/{id}")
	public void deleteTicket(@PathVariable int id) {
		
	}
}
