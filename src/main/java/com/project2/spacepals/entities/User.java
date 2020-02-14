package com.project2.spacepals.entities;

import com.project2.spacepals.web.dtos.Principal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "planet_of_residency", nullable = false)
    private String planetOfResidency;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){
        super();
    }

    public User(String firstName, String lastName, String email, String password, String planetOfResidency, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.planetOfResidency = planetOfResidency;
        this.gender = gender;
    }

    public User(int id, String firstName, String lastName, String email, String password, String planetOfResidency, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.planetOfResidency = planetOfResidency;
        this.gender = gender;
    }



    public User(int id, String firstName, String lastName, String email, String password, String planetOfResidency, String gender, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.planetOfResidency = planetOfResidency;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlanetOfResidency() {
        return planetOfResidency;
    }

    public void setPlanetOfResidency(String planetOfResidency) {
        this.planetOfResidency = planetOfResidency;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Principal extractPrincipal(){
        return new Principal(this.id, this.email,this.role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(planetOfResidency, user.planetOfResidency) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, planetOfResidency, gender, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", planetOfResidency='" + planetOfResidency + '\'' +
                ", gender='" + gender + '\'' +
                ", role=" + role +
                '}';
    }
}
