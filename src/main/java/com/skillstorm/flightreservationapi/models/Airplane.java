package com.skillstorm.flightreservationapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Airplane")
public class Airplane {

    @Id
    @GenericGenerator(name = "airplane_id", strategy = "com.skillstorm.flightreservationapi.services.AirplaneIdGenerator")
    @GeneratedValue(generator = "airplane_id")
    @Column(name = "airplane_id")
    private String id;

    @Column(name = "curent_capacity")
    @NotNull
    private int currentCapacity;

    @Column(name = "max_capacity")
    @NotNull
    private int maxCapacity;

    @Column
    @NotBlank
    private String model;

    @OneToMany(mappedBy = "airplane")
    @JsonManagedReference
    private Set<Seat> seats;

    @NotBlank
    @ManyToOne // defaults to eager
    @JoinColumn(name = "airline_id")
    private Airline airline;



    public Airplane() {
    }

    public Airplane(int currentCapacity, int maxCapacity, String model, Set<Seat> seats, Airline airline, Set<Flight> flights) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.model = model;
        this.seats = seats;
        this.airline = airline;
    }

    public Airplane(String id, int currentCapacity, int maxCapacity, String model, Set<Seat> seats, Airline airline, Set<Flight> flights) {
        this.id = id;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.model = model;
        this.seats = seats;
        this.airline = airline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return id.equals(airplane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    @Override
//    public String toString() {
//        return "Airplane{" +
//                "id='" + id + '\'' +
//                ", currentCapacity=" + currentCapacity +
//                ", maxCapacity=" + maxCapacity +
//                ", model='" + model + '\'' +
//                ", seats=" + seats +
//                ", airline=" + airline +
//                '}';
//    }
}
