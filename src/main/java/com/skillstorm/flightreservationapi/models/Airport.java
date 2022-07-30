package com.skillstorm.flightreservationapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Integer id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id")
    //@JsonBackReference
    //@JsonIdentityReference(alwaysAsId = true)
    private City city;

    public Airport() {
    }

    public Airport(String name, String code, City city) {
        this.name = name;
        this.code = code;
        this.city = city;
    }

    public Airport(int id, String name, String code, City city) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = city;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return id == airport.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", city=" + city +
                '}';
    }
}
