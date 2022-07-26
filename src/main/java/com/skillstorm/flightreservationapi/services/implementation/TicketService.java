package com.skillstorm.flightreservationapi.services.implementation;

import javax.transaction.Transactional;

import com.skillstorm.flightreservationapi.data.repositories.SeatRepository;
import com.skillstorm.flightreservationapi.data.repositories.UserRepository;
import com.skillstorm.flightreservationapi.models.Seat;
import com.skillstorm.flightreservationapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.flightreservationapi.data.repositories.GenericRepositoryImpl;
import com.skillstorm.flightreservationapi.data.repositories.TicketRepository;
import com.skillstorm.flightreservationapi.models.Ticket;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;

import java.util.*;

@Service
@Transactional
public class TicketService extends GenericRepositoryImpl<Ticket, Integer> implements TicketServiceInterface{
	private final TicketRepository ticketRepository;
	private final UserRepository userRepository;
	private final SeatRepository seatRepository;

	@Autowired
	public TicketService(TicketRepository ticketRepository, UserRepository userRepository, SeatRepository seatRepository) {
		super(ticketRepository);
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
		this.seatRepository = seatRepository;
	}

	@Override
	public Ticket update(Ticket ticket) {
		Set<Ticket> ticketSet = new HashSet<>();
		ticketSet.add(ticket);
		User newUser = new User(
				0,
				ticket.getUser().getFirstName(),
				ticket.getUser().getLastName(),
				ticket.getUser().getEmail(),
				ticket.getUser().getPhoneNumber()
//				ticketSet
		);

		User user = userRepository.save(newUser);
		if (user != null) {
			ticket.setUser(new User(
					user.getId(),
					user.getFirstName(),
					user.getLastName(),
					user.getEmail(),
					user.getPhoneNumber()
			));

			Ticket returnTicket = ticketRepository.save(ticket);
			if (returnTicket != null) {
				return returnTicket;
			}
		}

		return null;
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
					Seat savedSeat = seatRepository.save(seat);
					Ticket newTicket = new Ticket(
							ticket.getTicketType(),
							ticket.getFlight(),
							user,
							ticket.getDateOfPurchase(),
							savedSeat,
							ticket.getFrom(),
							ticket.getTo(),
							ticket.getPrice(),
							ticket.getNumberOfPassenger()
							);
					Ticket createdTicket = ticketRepository.save(newTicket);
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
		Ticket ticket = ticketRepository.findById(id).get();
		if (ticket != null) {
			ticket.getSeat().setTaken(false);
			Seat savedSeat = seatRepository.save(ticket.getSeat());
			ticket.setSeat(savedSeat);
			ticketRepository.save(ticket);
			ticketRepository.deleteById(id);
			// returns false if deleted
			return ticketRepository.findById(id).isPresent();
		}

		//Ticket was not deleted
		return true;
	}
}
