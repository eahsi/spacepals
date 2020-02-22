package com.project2.spacepals.web.dtos;

import com.project2.spacepals.entities.Flight;

import java.util.Objects;

public class FlightDto {
    private int companyId;
    private int shipId;
    private String deptName;
    private String destName;
    private Flight flight;

    public FlightDto() {
    }

    public FlightDto(int companyId, int shipId, Flight flight) {
        this.companyId = companyId;
        this.shipId = shipId;
        this.flight = flight;
    }

    public FlightDto(int companyId, int shipId, String deptName, String destName, Flight flight) {
        this.companyId = companyId;
        this.shipId = shipId;
        this.deptName = deptName;
        this.destName = destName;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return companyId == flightDto.companyId &&
                shipId == flightDto.shipId &&
                Objects.equals(deptName, flightDto.deptName) &&
                Objects.equals(destName, flightDto.destName) &&
                Objects.equals(flight, flightDto.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, shipId, deptName, destName, flight);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "companyId=" + companyId +
                ", shipId=" + shipId +
                ", deptName='" + deptName + '\'' +
                ", destName='" + destName + '\'' +
                ", flight=" + flight +
                '}';
    }
}
