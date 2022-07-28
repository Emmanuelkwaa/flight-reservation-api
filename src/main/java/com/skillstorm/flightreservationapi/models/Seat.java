package com.skillstorm.flightreservationapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer id;

    @Column(name = "seat_number")
    @NotNull
    private String seatNumber;

    @Column(name = "is_taken")
    @NotNull
    private boolean isTaken;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @OneToMany(mappedBy = "seat")
    private Set<Ticket> tickets;

    public Seat() {
    }

    public Seat(String seatNumber, boolean isTaken, Set<Ticket> tickets) {
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
        this.tickets = tickets;
    }

    public Seat(int id, String seatNumber, boolean isTaken, Set<Ticket> tickets) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
        this.tickets = tickets;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id;
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
                ", tickets=" + tickets +
                '}';
    }
}
