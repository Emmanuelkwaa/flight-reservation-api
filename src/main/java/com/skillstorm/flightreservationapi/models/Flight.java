package com.skillstorm.flightreservationapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Flight")
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
    @JoinColumn(name = "depart_airport_id")
    private Airport departAirport;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    public Flight() {
    }

    public Flight(
            String flightNumber,
            Airplane airplane,
            Airport departAirport,
            Airport arrivalAirport,
            Date departDateTime,
            Date arrivalDateTime,
            double economyPrice,
            double businessPrice
    ) {
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.departAirport = departAirport;
        this.arrivalAirport = arrivalAirport;
        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
    }

    public Flight(
            Integer id,
            String flightNumber,
            Airplane airplane,
            Airport departAirport,
            Airport arrivalAirport,
            Date departDateTime,
            Date arrivalDateTime,
            double economyPrice,
            double businessPrice
    ) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.departAirport = departAirport;
        this.arrivalAirport = arrivalAirport;
        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getDepartAirport() {
        return departAirport;
    }

    public void setDepartAirport(Airport departAirport) {
        this.departAirport = departAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

//    @Override
//    public String toString() {
//        return "Flight{" +
//                "id=" + id +
//                ", flightNumber='" + flightNumber + '\'' +
//                ", departAirport=" + departAirport +
//                ", arrivalAirport=" + arrivalAirport +
//                ", departDateTime=" + departDateTime +
//                ", arrivalDateTime=" + arrivalDateTime +
//                ", economyPrice=" + economyPrice +
//                ", businessPrice=" + businessPrice +
//                ", airplane=" + airplane +
//                '}';
//    }
}
