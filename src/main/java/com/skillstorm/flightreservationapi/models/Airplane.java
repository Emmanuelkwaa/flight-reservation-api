package com.skillstorm.flightreservationapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table
public class Airplane {

    //@Id
    private String id;
    private Airline airline;
    private int capacity;
    private String model;
    private Seat seat;

    public Airplane() {
    }

    public Airplane(Airline airline, int capacity, String model, Seat seat) {
        this.airline = airline;
        this.capacity = capacity;
        this.model = model;
        this.seat = seat;
    }

    public Airplane(String id, Airline airline, int capacity, String model, Seat seat) {
        this.id = id;
        this.airline = airline;
        this.capacity = capacity;
        this.model = model;
        this.seat = seat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", airline=" + airline +
                ", capacity=" + capacity +
                ", model='" + model + '\'' +
                ", seat=" + seat +
                '}';
    }
}
