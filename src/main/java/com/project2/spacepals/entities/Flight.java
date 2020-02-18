package com.project2.spacepals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FLIGHTS")
public class Flight implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double duration;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int availableSeats;

    @JoinColumn
    @OneToOne
    private Planet destination;

    @JoinColumn
    @OneToOne
    private Planet departure;

    @JoinColumn
    @OneToOne
    private Aircraft aircraft;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> passengers;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;


    public Flight() {
        super();
    }

    public Flight(Aircraft aircraft, double duration, Planet destination, Planet departure, double cost, Date date, int availableSeats, List<User> passengers, FlightStatus status) {
        this.aircraft = aircraft;
        this.duration = duration;
        this.destination = destination;
        this.departure = departure;
        this.cost = cost;
        this.date = date;
        this.availableSeats = availableSeats;
        this.passengers = passengers;
        this.status = status;
    }

    public Flight(int id, Aircraft aircraft, double duration, Planet destination, Planet departure, double cost, Date date, int availableSeats, List<User> passengers, FlightStatus status) {
        this.id = id;
        this.aircraft = aircraft;
        this.duration = duration;
        this.destination = destination;
        this.departure = departure;
        this.cost = cost;
        this.date = date;
        this.availableSeats = availableSeats;
        this.passengers = passengers;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Planet getDestination() {
        return destination;
    }

    public void setDestination(Planet destination) {
        this.destination = destination;
    }

    public Planet getDeparture() {
        return departure;
    }

    public void setDeparture(Planet departure) {
        this.departure = departure;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() &&
                Double.compare(flight.getDuration(), getDuration()) == 0 &&
                Double.compare(flight.getCost(), getCost()) == 0 &&
                getAvailableSeats() == flight.getAvailableSeats() &&
                Objects.equals(getAircraft(), flight.getAircraft()) &&
                Objects.equals(getDestination(), flight.getDestination()) &&
                Objects.equals(getDeparture(), flight.getDeparture()) &&
                Objects.equals(getDate(), flight.getDate()) &&
                Objects.equals(getPassengers(), flight.getPassengers()) &&
                getStatus() == flight.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAircraft(), getDuration(), getDestination(), getDeparture(), getCost(), getDate(), getAvailableSeats(), getPassengers(), getStatus());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", aircraft=" + aircraft +
                ", duration=" + duration +
                ", destination=" + destination +
                ", departure=" + departure +
                ", cost=" + cost +
                ", date=" + date +
                ", availableSeats=" + availableSeats +
                ", passengers=" + passengers +
                ", status=" + status +
                '}';
    }
}