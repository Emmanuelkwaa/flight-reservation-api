package com.skillstorm.flightreservationapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer id;

    @Column(name = "flight_number")
    @NotBlank
    private String flightNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "depart_city_id")
    private City arrivalCity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "arrival_city_id")
    private City fromCity;

    @Column(name = "depart_datetime")
    @NotNull
    private Date departDateTime;

    @Column(name = "arrival_datetime")
    @NotNull
    private Date arrivalDateTime;

    @Column(name = "economy_price")
    @NotNull
    private double economyPrice;

    @Column(name = "business_price")
    @NotNull
    private double businessPrice;

    public Flight() {
    }

    public Flight(String flightNumber,
                  Airplane airplane,
                  City arrivalCity,
                  City fromCity,
                  Date departDateTime,
                  Date arrivalDateTime,
                  double economyPrice,
                  double businessPrice
    ) {
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.arrivalCity = arrivalCity;
        this.fromCity = fromCity;
        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
    }

    public Flight(int id,
                  String flightNumber,
                  Airplane airplane,
                  City arrivalCity,
                  City fromCity,
                  Date departDateTime,
                  Date arrivalDateTime,
                  double economyPrice,
                  double businessPrice
    ) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.arrivalCity = arrivalCity;
        this.fromCity = fromCity;
        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public Date getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(Date departDateTime) {
        this.departDateTime = departDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", airplane=" + airplane +
                ", arrivalCity=" + arrivalCity +
                ", fromCity=" + fromCity +
                ", departDateTime=" + departDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", economyPrice=" + economyPrice +
                ", businessPrice=" + businessPrice +
                '}';
    }
}
