package com.skillstorm.flightreservationapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String country;

    @OneToMany(mappedBy = "city")
    private Set<Airport> airport;

    @OneToMany(mappedBy = "departCity")
    private Set<Flight> departFlight;

    @OneToMany(mappedBy = "arrivalCity")
    private Set<Flight> arrivalFlights;

    public City() {
    }

    public City(String name, String country, Set<Airport> airport, Set<Flight> departFlight, Set<Flight> arrivalFlights) {
        this.name = name;
        this.country = country;
        this.airport = airport;
        this.departFlight = departFlight;
        this.arrivalFlights = arrivalFlights;
    }

    public City(Integer id, String name, String country, Set<Airport> airport, Set<Flight> departFlight, Set<Flight> arrivalFlights) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.airport = airport;
        this.departFlight = departFlight;
        this.arrivalFlights = arrivalFlights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", airport=" + airport +
                ", departFlight=" + departFlight +
                ", arrivalFlights=" + arrivalFlights +
                '}';
    }
}
