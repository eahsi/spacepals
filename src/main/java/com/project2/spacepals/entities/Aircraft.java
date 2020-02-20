package com.project2.spacepals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "AIRCRAFTS")
public class Aircraft implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private double rate;

    @JoinColumn
    @ManyToOne(cascade={
            CascadeType.REMOVE, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST
    })
    @JsonIgnore
    private Company owner;
    /*
    @JoinColumn
    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private List<Flight> flights;

     */

    @Enumerated(EnumType.STRING)
    private Capacity capacity;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    public Aircraft() {
        super();
    }

    public Aircraft(String name, double rate, Capacity capacity, Company owner, RentalStatus status) {
        this.name = name;
        this.rate = rate;
        this.owner = owner;
        this.capacity = capacity;
        this.status = status;
    }

    public Aircraft(String name, double rate, Company owner, List<Flight> flights, Capacity capacity, RentalStatus status) {
        this.name = name;
        this.rate = rate;
        this.owner = owner;
        //this.flights = flights;
        this.capacity = capacity;
        this.status = status;
    }

    public Aircraft(int id, String name, double rate, Company owner, List<Flight> flights, Capacity capacity, RentalStatus status) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.owner = owner;
        //this.flights = flights;
        this.capacity = capacity;
        this.status = status;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Company getOwner() {
        return owner;
    }

    public void setOwner(Company owner) {
        this.owner = owner;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

//    public List<Flight> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(List<Flight> flights) {
//        this.flights = flights;
//    }
//
//    public void addFlight(Flight flight) {
//        if(flights == null) flights = new ArrayList<>();
//        flights.add(flight);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return id == aircraft.id &&
                Double.compare(aircraft.rate, rate) == 0 &&
                Objects.equals(name, aircraft.name) &&
                Objects.equals(owner, aircraft.owner) &&
                //Objects.equals(flights, aircraft.flights) &&
                capacity == aircraft.capacity &&
                status == aircraft.status;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, rate, owner, flights, capacity, status);
//    }
//
    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", owner=" + owner +
                //", flights=" + flights +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}
