package com.skillstorm.flightreservationapi.controllers;

import com.skillstorm.flightreservationapi.models.Reservation;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;
import com.skillstorm.flightreservationapi.services.unitOfWork.IUnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.flightreservationapi.models.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/tickets")
public class TicketController {

	private final IUnitOfWork unitOfWork;
	private TicketServiceInterface ticketServiceInterface;

	@Autowired
	public TicketController(IUnitOfWork unitOfWork, TicketServiceInterface ticketServiceInterface) {
		this.unitOfWork = unitOfWork;
		this.ticketServiceInterface = ticketServiceInterface;
	}

	@GetMapping("/{id}")
	public Ticket findById(@PathVariable int id) {
		return ticketServiceInterface.findById(id).get();
	}
	
	@PostMapping
	public ResponseEntity<List<Ticket>> createTicket(@RequestBody Reservation reservation) {
		Ticket ticket = new Ticket(
			reservation.getTicketType(),
			reservation.getFlight(),
			reservation.getUser(),
			reservation.getDateOfPurchase(),
			reservation.getSeat(),
			reservation.getFrom(),
			reservation.getTo(),
			reservation.getPrice(),
			reservation.getNumberOfPassenger()
		);

		List<Ticket> createdTickets = this.ticketServiceInterface.saveTicket(ticket);

		if(createdTickets == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(createdTickets, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<List<Ticket>> updateTicket(@PathVariable int id, @RequestBody Ticket ticket) {
		Ticket returnTicket = this.unitOfWork.ticket().update(ticket);
		if (returnTicket != null) {
			List<Ticket> tickets = new ArrayList<>();
			tickets.add(returnTicket);
			return new ResponseEntity<>(tickets, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteTicket(@PathVariable int id) {
		// returns false on delete
		boolean isDeleted = unitOfWork.ticket().delete(id);
		return isDeleted;
	}
}
