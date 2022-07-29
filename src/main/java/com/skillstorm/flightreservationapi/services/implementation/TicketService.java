package com.skillstorm.flightreservationapi.services.implementation;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.data.repositories.TicketRepository;
import com.skillstorm.flightreservationapi.models.Ticket;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;

@Service
@Transactional
public class TicketService extends GenericRepositoryImpl<Ticket, String> implements TicketServiceInterface{
	private TicketRepository ticketRepository;
	
	public TicketService(TicketRepository ticketRepository) {
		super(ticketRepository);
	}
}
