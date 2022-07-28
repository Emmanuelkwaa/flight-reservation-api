package com.skillstorm.flightreservationapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @OneToMany(mappedBy = "airline")
    private Set<Airport> airport;

    @OneToMany(mappedBy = "airplane")
    private Set<Flight> flights;

    public City() {
    }

    public City(String name, String country, Set<Airport> airport) {
        this.name = name;
        this.country = country;
        this.airport = airport;
    }

    public City(int id, String name, String country, Set<Airport> airport) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.airport = airport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
