package com.project2.spacepals.entities;

<<<<<<< HEAD
public class Flight {

    private int id;
    private int seats;
    private int availableSeats;
    private int aircraft; // probably changing to an aircraft Object / enum
    private int companyId;
    private int flightDuration;
    private int destination;
    private int departurePointId;
    private double cost;
    private int statusId;
=======
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="FLIGHTS")
@SequenceGenerator(name="flight_seq_gen", sequenceName = "flight_seq", allocationSize = 1)
public class Flight {

    @Id
    @Column(name="flight_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="available_seats", nullable = false)
    private int availableSeats;

    @Column(name="total_seats", nullable = false)
    private int totalSeats;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @Column(name="flight_duration")
    private String flightDuration;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Planet flightDestination;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Planet flightDeparture;

    @Column(name="flight_cost")
    private double flightCost;

    @Enumerated(EnumType.ORDINAL)
    private FlightStatus flightStatus;

    @JoinTable(name = "USERS_FLIGHTS", joinColumns = @JoinColumn(name="flight_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Users> passengers ;

    public Flight(){
        super();
    }

    public Flight(int availableSeats, int totalSeats, Company company, String flightDuration, Planet flightDestination, Planet flightDeparture, double flightCost, FlightStatus flightStatus, List<Users> passengers) {
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.company = company;
        this.flightDuration = flightDuration;
        this.flightDestination = flightDestination;
        this.flightDeparture = flightDeparture;
        this.flightCost = flightCost;
        this.flightStatus = flightStatus;
        this.passengers = passengers;
    }

    public Flight(int id, int availableSeats, int totalSeats, Company company, String flightDuration, Planet flightDestination, Planet flightDeparture, double flightCost, FlightStatus flightStatus, List<Users> passengers) {
        this.id = id;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.company = company;
        this.flightDuration = flightDuration;
        this.flightDestination = flightDestination;
        this.flightDeparture = flightDeparture;
        this.flightCost = flightCost;
        this.flightStatus = flightStatus;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Planet getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(Planet flightDestination) {
        this.flightDestination = flightDestination;
    }

    public Planet getFlightDeparture() {
        return flightDeparture;
    }

    public void setFlightDeparture(Planet flightDeparture) {
        this.flightDeparture = flightDeparture;
    }

    public double getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(double flightCost) {
        this.flightCost = flightCost;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public List<Users> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Users> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                availableSeats == flight.availableSeats &&
                totalSeats == flight.totalSeats &&
                Double.compare(flight.flightCost, flightCost) == 0 &&
                Objects.equals(company, flight.company) &&
                Objects.equals(flightDuration, flight.flightDuration) &&
                Objects.equals(flightDestination, flight.flightDestination) &&
                Objects.equals(flightDeparture, flight.flightDeparture) &&
                flightStatus == flight.flightStatus &&
                Objects.equals(passengers, flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availableSeats, totalSeats, company, flightDuration, flightDestination, flightDeparture, flightCost, flightStatus, passengers);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", availableSeats=" + availableSeats +
                ", totalSeats=" + totalSeats +
                ", company=" + company +
                ", flightDuration='" + flightDuration + '\'' +
                ", flightDestination=" + flightDestination +
                ", flightDeparture=" + flightDeparture +
                ", flightCost=" + flightCost +
                ", flightStatus=" + flightStatus +
                ", passengers=" + passengers +
                '}';
    }
>>>>>>> c8b5f75d7054988acc6f38daf7775736a7c90e9f
}
