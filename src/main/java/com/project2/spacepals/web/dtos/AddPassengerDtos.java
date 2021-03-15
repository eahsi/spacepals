package com.project2.spacepals.web.dtos;

import java.util.Objects;

public class AddPassengerDtos {
    private int id;

    public AddPassengerDtos() {
        super();
    }

    public AddPassengerDtos(int id) {
        this.id = id;
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
        if (!(o instanceof AddPassengerDtos)) return false;
        AddPassengerDtos that = (AddPassengerDtos) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "AddPassengerDtos{" +
                "id=" + id +
                '}';
    }
}
