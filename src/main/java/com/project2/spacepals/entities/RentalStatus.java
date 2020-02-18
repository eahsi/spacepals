package com.project2.spacepals.entities;

public enum RentalStatus {

    AVALABLE("Availble"), UNAVAILABLE("Unvailable");

    private String rentalStatusName;

    RentalStatus(String rentalStatusName) {
        this.rentalStatusName = rentalStatusName;
    }
}
