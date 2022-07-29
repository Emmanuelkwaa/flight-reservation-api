package com.skillstorm.flightreservationapi.data.repositories;

import org.springframework.stereotype.Repository;

import com.skillstorm.flightreservationapi.models.Ticket;

@Repository
public interface TicketRepository extends GenericRepository<Ticket, String> {

}
