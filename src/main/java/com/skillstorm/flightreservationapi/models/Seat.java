package com.skillstorm.flightreservationapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer id;

    @Column(name = "seat_number")
    @NotBlank
    private String seatNumber;

    @Column(name = "is_taken")
    @NotBlank
    private boolean isTaken;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    @JsonBackReference
    private Airplane airplane;

    public Seat() {
    }

    public Seat(String seatNumber, boolean isTaken, Airplane airplane) {
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
        this.airplane = airplane;
    }

    public Seat(Integer id, String seatNumber, boolean isTaken, Airplane airplane) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
        this.airplane = airplane;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id.equals(seat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber='" + seatNumber + '\'' +
                ", isTaken=" + isTaken +
                ", airplane=" + airplane +
                '}';
    }
}
