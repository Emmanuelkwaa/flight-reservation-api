package com.skillstorm.flightreservationapi.models;

import java.util.Date;

public class Ticket {
    private String id;
    private Flight flight;
    private User user;
    private Date dateOfPurchase;
    private Seat seat;
    private double price;

    public Ticket() {
    }

    public Ticket(Flight flight, User user, Date dateOfPurchase, Seat seat, double price) {
        this.flight = flight;
        this.user = user;
        this.dateOfPurchase = dateOfPurchase;
        this.seat = seat;
        this.price = price;
    }

    public Ticket(String id, Flight flight, User user, Date dateOfPurchase, Seat seat, double price) {
        this.id = id;
        this.flight = flight;
        this.user = user;
        this.dateOfPurchase = dateOfPurchase;
        this.seat = seat;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", flight=" + flight +
                ", user=" + user +
                ", dateOfPurchase=" + dateOfPurchase +
                ", seat=" + seat +
                ", price=" + price +
                '}';
    }
}
