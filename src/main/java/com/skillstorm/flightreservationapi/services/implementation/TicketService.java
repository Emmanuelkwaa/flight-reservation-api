package com.skillstorm.flightreservationapi.services.implementation;

import javax.transaction.Transactional;

import com.skillstorm.flightreservationapi.data.repositories.UserRepository;
import com.skillstorm.flightreservationapi.models.Seat;
import com.skillstorm.flightreservationapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.data.repositories.TicketRepository;
import com.skillstorm.flightreservationapi.models.Ticket;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class TicketService extends GenericRepositoryImpl<Ticket, Integer> implements TicketServiceInterface{
	private TicketRepository ticketRepository;
	private UserRepository userRepository;

	@Autowired
	public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
		super(ticketRepository);
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Ticket> saveTicket(Ticket ticket) {
		int currentCapacity = ticket.getFlight().getAirplane().getCurrentCapacity();
		int maxCapacity = ticket.getFlight().getAirplane().getMaxCapacity();

		if(currentCapacity < maxCapacity) {
			currentCapacity += ticket.getNumberOfPassenger();
			ticket.getFlight().getAirplane().setCurrentCapacity(currentCapacity);

			List<Seat> avaialableSeats = new LinkedList<>();

			for (Seat seat:ticket.getFlight().getAirplane().getSeats()) {
				if(!seat.isTaken()) {
					avaialableSeats.add(seat);
				}
			}

			List<Seat> randomSelectedSeat = getRandomSeat(avaialableSeats, ticket.getNumberOfPassenger());
			List<Ticket> tickets = new ArrayList<>();

			User user = userRepository.save(ticket.getUser());

			if(user != null) {
				for (Seat seat : randomSelectedSeat) {
					seat.setTaken(true);
					ticket.setSeat(seat);
					ticket.getUser().setId(user.getId());
					Ticket createdTicket = ticketRepository.save(ticket);
					if(createdTicket != null) {
						tickets.add(createdTicket);
					}
				}

				return tickets;
			}


		}

		return null;
	}

	private List<Seat> getRandomSeat(List<Seat> seats, int numberOfSeats) {
		Random rand = new Random();
		int randomNum = 0;

		List<Seat> pickedSeat = new LinkedList<>();

		for (int i = 0; i < numberOfSeats; i++) {
			randomNum = rand.nextInt(seats.size()-1)+1;
			pickedSeat.add(seats.get(randomNum));
		}

		return pickedSeat;
	}

	@Override
	public boolean delete(int id) {
		ticketRepository.deleteById(id);
		return ticketRepository.findById(id).isPresent();
	}
}
