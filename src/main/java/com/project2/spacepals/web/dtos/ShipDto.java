package com.project2.spacepals.web.dtos;

import com.project2.spacepals.entities.Aircraft;

import java.util.Objects;

public class ShipDto {
    private Aircraft aircraft;
    private int id;

    public ShipDto() {
    }

    public ShipDto(Aircraft aircraft, int id) {
        this.aircraft = aircraft;
        this.id = id;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipDto shipDto = (ShipDto) o;
        return id == shipDto.id &&
                Objects.equals(aircraft, shipDto.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraft, id);
    }

    @Override
    public String toString() {
        return "ShipDto{" +
                "aircraft=" + aircraft +
                ", id=" + id +
                '}';
    }
}
