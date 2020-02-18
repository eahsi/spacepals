package com.project2.spacepals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rental implements Serializable { // thinking of changing this class name to Aircraft

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Aircraft aircraft;

    @Column
    private User rentee;

    @Column
    private Date rentalDate;

    @Column
    private Date returnDate;

    public Rental() {
        super();
    }

    public Rental(Aircraft aircraft, User rentee, Date rentalDate, Date returnDate) {
        this.aircraft = aircraft;
        this.rentee = rentee;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Rental(int id, Aircraft aircraft, User rentee, Date rentalDate, Date returnDate) {
        this.id = id;
        this.aircraft = aircraft;
        this.rentee = rentee;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
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

    public User getRentee() {
        return rentee;
    }

    public void setRentee(User rentee) {
        this.rentee = rentee;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;
        Rental rental = (Rental) o;
        return getId() == rental.getId() &&
                Objects.equals(getAircraft(), rental.getAircraft()) &&
                Objects.equals(getRentee(), rental.getRentee()) &&
                Objects.equals(getRentalDate(), rental.getRentalDate()) &&
                Objects.equals(getReturnDate(), rental.getReturnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAircraft(), getRentee(), getRentalDate(), getReturnDate());
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", aircraft=" + aircraft +
                ", rentee=" + rentee +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
