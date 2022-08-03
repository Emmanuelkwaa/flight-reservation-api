package com.skillstorm.flightreservationapi.controllers;

import com.skillstorm.flightreservationapi.models.Reservation;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;
import com.skillstorm.flightreservationapi.services.unitOfWork.IUnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.flightreservationapi.models.Ticket;

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
		Optional<Ticket> ticket = unitOfWork.ticket().findById(id);
		return ticket.isPresent() ? ticket.get() : null;
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
	public Ticket updateTicket(@PathVariable int id) {
		return new Ticket();
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteTicket(@PathVariable int id) {
		return unitOfWork.ticket().delete(id);
	}
}
