package com.project2.spacepals.web.dtos;

import com.project2.spacepals.entities.Flight;

import java.util.Objects;

public class FlightDto {
    private int companyId;
    private int shipId;
    private Flight flight;

    public FlightDto() {
    }

    public FlightDto(int companyId, int shipId, Flight flight) {
        this.companyId = companyId;
        this.shipId = shipId;
        this.flight = flight;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return companyId == flightDto.companyId &&
                shipId == flightDto.shipId &&
                Objects.equals(flight, flightDto.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, shipId, flight);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "companyId=" + companyId +
                ", shipId=" + shipId +
                ", flight=" + flight +
                '}';
    }
}
