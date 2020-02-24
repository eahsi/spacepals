package com.project2.spacepals.web.dtos;

import java.util.Objects;

public class AircraftDto {

    private String name;
    private String capacity;
    private int companyId;

    public AircraftDto() {
        super();
    }

    public AircraftDto(String name, String capacity, int companyId) {
        this.name = name;
        this.capacity = capacity;
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AircraftDto)) return false;
        AircraftDto that = (AircraftDto) o;
        return getCompanyId() == that.getCompanyId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCapacity(), that.getCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapacity(), getCompanyId());
    }

    @Override
    public String toString() {
        return "AircraftDto{" +
                "name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
