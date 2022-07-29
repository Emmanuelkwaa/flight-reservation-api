package com.skillstorm.flightreservationapi.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
    @JsonManagedReference
    private Set<Airport> airport;

//    @OneToMany(mappedBy = "departCity")
//    private Set<Flight> departFlight;
//
//    @OneToMany(mappedBy = "arrivalCity")
//    private Set<Flight> arrivalFlights;

    public City() {
    }

    public City(String name, String country, Set<Airport> airport) {
        this.name = name;
        this.country = country;
        this.airport = airport;
    }

    public City(Integer id, String name, String country, Set<Airport> airport) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.airport = airport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Airport> getAirport() {
        return airport;
    }

    public void setAirport(Set<Airport> airport) {
        this.airport = airport;
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
                '}';
    }
}
