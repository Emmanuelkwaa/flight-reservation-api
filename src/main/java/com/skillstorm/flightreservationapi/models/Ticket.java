package com.skillstorm.flightreservationapi.models;

import java.util.Date;

public class Ticket {
    private String id;
    private Flight flight;
    private User user;
    private Date dateOfPurchase;
    private Seat seat;
    private double price;
}
