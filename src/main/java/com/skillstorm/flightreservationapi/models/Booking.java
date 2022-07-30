package com.skillstorm.flightreservationapi.models;

import java.util.Date;

public class Booking {
    private String tripType;
    private int numberOfPassengers;
    private String tripClass;
    private City departCity;
    private City arrivalCity;
    private Date date;

    public Booking() {
    }

    public Booking(String tripType, int numberOfPassengers, String tripClass, City departCity, City arrivalCity, Date date) {
        this.tripType = tripType;
        this.numberOfPassengers = numberOfPassengers;
        this.tripClass = tripClass;
        this.departCity = departCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getTripClass() {
        return tripClass;
    }

    public void setTripClass(String tripClass) {
        this.tripClass = tripClass;
    }

    public City getDepartCity() {
        return departCity;
    }

    public void setDepartCity(City departCity) {
        this.departCity = departCity;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "tripType='" + tripType + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", tripClass='" + tripClass + '\'' +
                ", departCity=" + departCity +
                ", arrivalCity=" + arrivalCity +
                ", date=" + date +
                '}';
    }
}
