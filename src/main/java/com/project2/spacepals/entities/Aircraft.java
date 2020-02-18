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
    private String name;

    @Column(nullable = false, unique = true)
    private double rate;

    @JoinColumn
    @ManyToOne(cascade={
            CascadeType.REMOVE, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST
    })
    private Company owner;

    @Enumerated(EnumType.STRING)
    private Capacity capacity;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    public Aircraft() {
        super();
    }

    public Aircraft(String name, double rate, Company owner, Capacity capacity, RentalStatus status) {
        this.name = name;
        this.rate = rate;
        this.owner = owner;
        this.capacity = capacity;
        this.status = status;
    }

    public Aircraft(int id, String name, double rate, Company owner, Capacity capacity, RentalStatus status) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.owner = owner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;
        return getId() == aircraft.getId() &&
                Double.compare(aircraft.getRate(), getRate()) == 0 &&
                Objects.equals(getName(), aircraft.getName()) &&
                Objects.equals(getOwner(), aircraft.getOwner()) &&
                getCapacity() == aircraft.getCapacity() &&
                getStatus() == aircraft.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRate(), getOwner(), getCapacity(), getStatus());
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", owner=" + owner +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}
