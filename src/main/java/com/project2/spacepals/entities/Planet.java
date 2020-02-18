package com.project2.spacepals.entities;

import javax.persistence.*;
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

    public Planet(){
        super();
    }

    public Planet(String planetName, int numberOfMoons, double gravity, int hoursInDay, double distanceFromEarth) {
        this.planetName = planetName;
        this.numberOfMoons = numberOfMoons;
        this.gravity = gravity;
        this.hoursInDay = hoursInDay;
        this.distanceFromEarth = distanceFromEarth;
    }

    public Planet(int id, String planetName, int numberOfMoons, double gravity, int hoursInDay, double distanceFromEarth) {
        this.id = id;
        this.planetName = planetName;
        this.numberOfMoons = numberOfMoons;
        this.gravity = gravity;
        this.hoursInDay = hoursInDay;
        this.distanceFromEarth = distanceFromEarth;
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
                Objects.equals(planetName, planet.planetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planetName, numberOfMoons, gravity, hoursInDay, distanceFromEarth);
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
                '}';
    }
}
