package com.skillstorm.flightreservationapi.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
//    @GenericGenerator(name = "ticket_id", strategy = "com.skillstorm.flightreservationapi.services.TicketIdGenerator")
//    @GeneratedValue(generator = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @NotNull
    @Column(name = "ticket_type")
    private String ticketType;

    @NotNull
    @ManyToOne // defaults to eager
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @NotNull
    @ManyToOne // defaults to eager
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    @NotNull
    @ManyToOne // defaults to eager
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @NotNull
    @Column(name = "[from]")
    private String from;

    @NotNull
    @Column(name = "[to]")
    private String to;

    @NotNull
    @Column
    private double price;

    @NotNull
    @Column
    private int numberOfPassenger;

    public Ticket() {
    }

    public Ticket(String ticketType, Flight flight, User user, Date dateOfPurchase, Seat seat, String from, String to, double price, int numberOfPassenger) {
        this.ticketType = ticketType;
        this.flight = flight;
        this.user = user;
        this.dateOfPurchase = dateOfPurchase;
        this.seat = seat;
        this.from = from;
        this.to = to;
        this.price = price;
        this.numberOfPassenger = numberOfPassenger;
    }

    public Ticket(int id, String ticketType, Flight flight, User user, Date dateOfPurchase, Seat seat, String from, String to, double price, int numberOfPassenger) {
        this.id = id;
        this.ticketType = ticketType;
        this.flight = flight;
        this.user = user;
        this.dateOfPurchase = dateOfPurchase;
        this.seat = seat;
        this.from = from;
        this.to = to;
        this.price = price;
        this.numberOfPassenger = numberOfPassenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassenger = numberOfPassenger;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketType='" + ticketType + '\'' +
                ", flight=" + flight +
                ", user=" + user +
                ", dateOfPurchase=" + dateOfPurchase +
                ", seat=" + seat +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                ", numberOfPassenger=" + numberOfPassenger +
                '}';
    }
}
