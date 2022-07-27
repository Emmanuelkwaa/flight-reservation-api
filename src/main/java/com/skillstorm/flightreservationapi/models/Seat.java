package com.skillstorm.flightreservationapi.models;

public class Seat {
    private int id;
    private String seatNumber;
    private boolean isTaken;

    public Seat() {
    }

    public Seat(String seatNumber, boolean isTaken) {
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
    }

    public Seat(int id, String seatNumber, boolean isTaken) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber='" + seatNumber + '\'' +
                ", isTaken=" + isTaken +
                '}';
    }
}
