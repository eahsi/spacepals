package com.project2.spacepals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Company implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String address;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private User manager;
    @OneToMany(mappedBy = "company")
    private List<Aircraft> aircrafts;

    public Company() {
        super();
    }

    public Company(String name, String address, User manager) {
        this.name = name;
        this.address = address;
        this.manager = manager;
    }

    public Company(String name, String address, User manager, List<Aircraft> aircrafts) {
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.aircrafts = aircrafts;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getId() == company.getId() &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getAddress(), company.getAddress()) &&
                Objects.equals(getManager(), company.getManager()) &&
                Objects.equals(getAircrafts(), company.getAircrafts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getManager(), getAircrafts());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manager=" + manager +
                ", aircrafts=" + aircrafts +
                '}';
    }
}
