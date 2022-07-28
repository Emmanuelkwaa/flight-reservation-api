package com.skillstorm.flightreservationapi.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
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



    @NotBlank
    @ManyToOne // defaults to eager
    @JoinColumn(name = "airline_id")
    private Airline airline;



    public Airplane() {
    }

    public Airplane(int currentCapacity, int maxCapacity, String model, Airline airline) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.model = model;
        this.airline = airline;
    }

    public Airplane(String id, int currentCapacity, int maxCapacity, String model, Airline airline) {
        this.id = id;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.model = model;
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

    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", currentCapacity=" + currentCapacity +
                ", maxCapacity=" + maxCapacity +
                ", airline=" + airline +
                '}';
    }
}
