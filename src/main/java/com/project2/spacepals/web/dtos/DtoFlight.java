package com.project2.spacepals.web.dtos;

import java.util.Date;
import java.util.Objects;

public class DtoFlight {

    private double cost;
    private int departure;
    private int destination;
    private int aircraftId;

    public DtoFlight() {
        super();
    }

    public DtoFlight(double cost, int departure, int destination, int aircraftId) {
        this.cost = cost;
        this.departure = departure;
        this.destination = destination;
        this.aircraftId = aircraftId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDeparture() {
        return departure;
    }

    public void setDeparture(int departure) {
        this.departure = departure;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DtoFlight)) return false;
        DtoFlight dtoFlight = (DtoFlight) o;
        return Double.compare(dtoFlight.getCost(), getCost()) == 0 &&
                getDeparture() == dtoFlight.getDeparture() &&
                getDestination() == dtoFlight.getDestination() &&
                getAircraftId() == dtoFlight.getAircraftId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCost(), getDeparture(), getDestination(), getAircraftId());
    }

    @Override
    public String toString() {
        return "DtoFlight{" +
                "cost=" + cost +
                ", departure=" + departure +
                ", destination=" + destination +
                ", aircraftId=" + aircraftId +
                '}';
    }
}
