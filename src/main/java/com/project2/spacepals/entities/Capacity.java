package com.project2.spacepals.entities;

public enum Capacity {

    SMALL(0, "Small", 100), MEDIUM(1, "Medium", 200), LARGE(2,"Large" ,300);

    private int id;
    private String name;
    private int capacity;

    Capacity() {
    }

    Capacity(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public static Capacity getById(int id){
        for(Capacity cap: Capacity.values()){
            if(cap.id == id){
                return cap;
            }
        }
        return Capacity.SMALL;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
