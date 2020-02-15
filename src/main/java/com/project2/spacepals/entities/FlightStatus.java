package com.project2.spacepals.entities;

public enum FlightStatus {

    OPEN(0,"Open"), CLOSED(1,"Closed"), CANCELED(2,"Canceled");

    private int id;
    private String status;

    FlightStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }
    public static FlightStatus getById(int id) {
        for (FlightStatus flightStatus : FlightStatus.values()) {
            if (flightStatus.id == id) {
                return flightStatus;
            }
        }
        return FlightStatus.CLOSED;
    }
    @Override
    public String toString() {
        return "FlightStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
