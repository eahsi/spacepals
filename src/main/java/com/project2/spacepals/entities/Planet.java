package com.project2.spacepals.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PLANETS")
@SequenceGenerator(name="planet_seq_gen",sequenceName = "planet_seq",allocationSize = 1)
public class Planet {

    @Id
    @Column(name="planet_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="planet_name", nullable = false)
    private String planetName;

    @Column(name="number_of_moons")
    private int numberOfMoons;

    @Column(name="gravity")
    private double gravity;

    @Column(name = "hours_in_day")
    private int hoursInDay;

    @Column(name="distance_from_earth")
    private double distanceFromEarth;

    @OneToMany(mappedBy = "flightDestination")
    private List<Flight> arrivingFlights;

    @OneToMany(mappedBy = "flightDeparture")
    private List<Flight> departingFlights;

    public Planet(){
        super();
    }

    public Planet(String planetName, int numberOfMoons, double gravity, int hoursInDay, double distanceFromEarth, List<Flight> arrivingFlights, List<Flight> departingFlights) {
        this.planetName = planetName;
        this.numberOfMoons = numberOfMoons;
        this.gravity = gravity;
        this.hoursInDay = hoursInDay;
        this.distanceFromEarth = distanceFromEarth;
        this.arrivingFlights = arrivingFlights;
        this.departingFlights = departingFlights;
    }

    public Planet(int id, String planetName, int numberOfMoons, double gravity, int hoursInDay, double distanceFromEarth, List<Flight> arrivingFlights, List<Flight> departingFlights) {
        this.id = id;
        this.planetName = planetName;
        this.numberOfMoons = numberOfMoons;
        this.gravity = gravity;
        this.hoursInDay = hoursInDay;
        this.distanceFromEarth = distanceFromEarth;
        this.arrivingFlights = arrivingFlights;
        this.departingFlights = departingFlights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public int getHoursInDay() {
        return hoursInDay;
    }

    public void setHoursInDay(int hoursInDay) {
        this.hoursInDay = hoursInDay;
    }

    public double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(double distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    public List<Flight> getArrivingFlights() {
        return arrivingFlights;
    }

    public void setArrivingFlights(List<Flight> arrivingFlights) {
        this.arrivingFlights = arrivingFlights;
    }

    public List<Flight> getDepartingFlights() {
        return departingFlights;
    }

    public void setDepartingFlights(List<Flight> departingFlights) {
        this.departingFlights = departingFlights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id &&
                numberOfMoons == planet.numberOfMoons &&
                Double.compare(planet.gravity, gravity) == 0 &&
                hoursInDay == planet.hoursInDay &&
                Double.compare(planet.distanceFromEarth, distanceFromEarth) == 0 &&
                Objects.equals(planetName, planet.planetName) &&
                Objects.equals(arrivingFlights, planet.arrivingFlights) &&
                Objects.equals(departingFlights, planet.departingFlights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planetName, numberOfMoons, gravity, hoursInDay, distanceFromEarth, arrivingFlights, departingFlights);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", planetName='" + planetName + '\'' +
                ", numberOfMoons=" + numberOfMoons +
                ", gravity=" + gravity +
                ", hoursInDay=" + hoursInDay +
                ", distanceFromEarth=" + distanceFromEarth +
                ", arrivingFlights=" + arrivingFlights +
                ", departingFlights=" + departingFlights +
                '}';
    }
}
