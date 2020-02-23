package com.project2.spacepals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "AIRCRAFTS")
public class Aircraft implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;


    @JoinColumn
    @ManyToOne(cascade = {
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


    public Aircraft() {
        super();
    }

    public Aircraft(String name, Capacity capacity, Company owner) {
        this.name = name;
        this.owner = owner;
        this.capacity = capacity;
    }

    public Aircraft(int id, String name, Company owner, Capacity capacity) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.capacity = capacity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;
        return getId() == aircraft.getId() &&
                Objects.equals(getName(), aircraft.getName()) &&
                Objects.equals(getOwner(), aircraft.getOwner()) &&
                getCapacity() == aircraft.getCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOwner(), getCapacity());
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", capacity=" + capacity +
                '}';
    }
}