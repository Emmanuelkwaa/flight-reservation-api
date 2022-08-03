package com.skillstorm.flightreservationapi.models;

import java.util.Date;

public class Reservation {
    private String ticketType;
    private Flight flight;
    private User user;
    private Date dateOfPurchase;
    private Seat seat;
    private String from;
    private String to;
    private double price;
    private int numberOfPassenger;

    public Reservation() {
    }

    public Reservation(String ticketType, Flight flight, User user, Date dateOfPurchase, Seat seat, String from, String to, int numberOfPassenger, double price) {
        this.ticketType = ticketType;
        this.flight = flight;
        this.user = user;
        this.dateOfPurchase = dateOfPurchase;
        this.seat = seat;
        this.from = from;
        this.to = to;
        this.numberOfPassenger = numberOfPassenger;
        this.price = price;
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

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassenger = numberOfPassenger;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "ticketType='" + ticketType + '\'' +
                ", flight=" + flight +
                ", user=" + user +
                ", dateOfPurchase=" + dateOfPurchase +
                ", seat=" + seat +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", numberOfPassenger=" + numberOfPassenger +
                ", price=" + price +
                '}';
    }
}
