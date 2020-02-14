package com.project2.spacepals.entities;



public enum Role {

    BASIC_USER(1,"Basic User"), FLIGHT_MANAGER(2,"Flight Manager"),
    ADMIN(3,"Admin"),LOCKED(4,"Locked");


    private int id;
    private String role_name;



    Role(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
