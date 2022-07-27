package com.skillstorm.flightreservationapi.models;

public class City {
    private int id;
    private String name;
    private String country;
    private Airport airport;

    public City() {
    }

    public City(String name, String country, Airport airport) {
        this.name = name;
        this.country = country;
        this.airport = airport;
    }

    public City(int id, String name, String country, Airport airport) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.airport = airport;
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
