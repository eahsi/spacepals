package com.project2.spacepals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "AIRCRAFTS")
public class Aircraft implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private double rate;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Capacity capacity;

    public Aircraft() {
        super();
    }

    public Aircraft(String name, Capacity capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Aircraft(int id, String name, Company owner, Capacity capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public Aircraft(String name, Capacity capacity, double rate) {
        this.name = name;
        this.capacity = capacity;
        this.rate = rate;
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

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;
        return getId() == aircraft.getId() &&
                Double.compare(aircraft.getRate(), getRate()) == 0 &&
                Objects.equals(getName(), aircraft.getName()) &&
                getCapacity() == aircraft.getCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRate(), getName(), getCapacity());
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", rate=" + rate +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}