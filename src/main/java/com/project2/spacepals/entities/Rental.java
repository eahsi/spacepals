package com.project2.spacepals.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rental implements Serializable { // thinking of changing this class name to Aircraft

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double rentalRate;

   @JoinColumn
   @ManyToOne()
    private Users renter; // the one who is renting? or who???

    @Column
    private Users rentee;

    @Column(nullable = false)
    private Capacity capacity;


}
