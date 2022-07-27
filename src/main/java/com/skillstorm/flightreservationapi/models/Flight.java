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

    public Flight() {
    }

    public Flight(String flightNumber,
                  Airplane airplane,
                  City arrivalCity,
                  City fromCity,
                  Date departDateTime,
                  Date arrivalDateTime,
                  int capacity,
                  double economyPrice,
                  double businessPrice
    ) {
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.arrivalCity = arrivalCity;
        this.fromCity = fromCity;
        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.capacity = capacity;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
    }

    public Flight(int id,
                  String flightNumber,
                  Airplane airplane,
                  City arrivalCity,
                  City fromCity,
                  Date departDateTime,
                  Date arrivalDateTime,
                  int capacity,
                  double economyPrice,
                  double businessPrice
    ) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.arrivalCity = arrivalCity;
        this.fromCity = fromCity;
        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.capacity = capacity;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public Date getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(Date departDateTime) {
        this.departDateTime = departDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", airplane=" + airplane +
                ", arrivalCity=" + arrivalCity +
                ", fromCity=" + fromCity +
                ", departDateTime=" + departDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", capacity=" + capacity +
                ", economyPrice=" + economyPrice +
                ", businessPrice=" + businessPrice +
                '}';
    }
}
