package com.project2.spacepals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COMPANIES")
public class Company implements Serializable {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String address;

//    @JoinColumn
//    @ManyToOne(cascade={
//            CascadeType.REMOVE, CascadeType.DETACH,
//            CascadeType.MERGE, CascadeType.PERSIST
//    })
//    @JsonIgnore
//    private User manager;

    @JoinColumn
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Aircraft> aircrafts;

    public Company() {
        super();
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Company(String name, String address, List<Aircraft> aircrafts) {
        this.name = name;
        this.address = address;
        this.aircrafts = aircrafts;
    }

    public Company(int id, String name, String address, List<Aircraft> aircrafts) {
        this.id = id;
        this.name = name;
        this.address = address;
//        this.manager = manager;
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

//    public User getManager() {
//        return manager;
//    }
//
//    public void setManager(User manager) {
//        this.manager = manager;
//    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void addAircraft(Aircraft aircraft){
        if(aircrafts == null) aircrafts = new ArrayList<>();
            //aircraft.setOwner(this);
            aircrafts.add(aircraft);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getId() == company.getId() &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getAddress(), company.getAddress()) &&
                Objects.equals(getAircrafts(), company.getAircrafts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getAircrafts());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", aircrafts=" + aircrafts +
               // ", manager =" + manager +
                '}';
    }
}
