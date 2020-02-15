package com.project2.spacepals.entities;



public enum Role {

    BASIC_USER(0,"Basic User"), FLIGHT_MANAGER(1,"Flight Manager"),
    ADMIN(2,"Admin"),LOCKED(3,"Locked");


    private int id;
    private String role_name;



    Role(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public static Role getById(int id) {
        for (Role role : Role.values()) {
            if (role.id == id) {
                return role;
            }
        }
        return Role.LOCKED;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
