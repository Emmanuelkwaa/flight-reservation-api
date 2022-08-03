package com.skillstorm.flightreservationapi.services.interfaces;

import com.skillstorm.flightreservationapi.models.Ticket;

import java.util.List;

public interface TicketServiceInterface extends GenericService<Ticket, Integer> {
    List<Ticket> saveTicket(Ticket ticket);
    boolean delete(int id);
}
