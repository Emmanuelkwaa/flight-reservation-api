package com.skillstorm.flightreservationapi.models;

import java.util.Date;

public class Flight {
    private int id;
    private String flightNumber;
    private Airplane airplane;
    private City arrivalCity;
    private City fromCity;
    private Date departDateTime;
    private Date arrivalDateTime;
    private int capacity;
    private double economyPrice;
    private double businessPrice;


}
