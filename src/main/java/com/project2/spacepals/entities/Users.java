package com.project2.spacepals.entities;

import com.project2.spacepals.web.dtos.Principal;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="USERS")
@SequenceGenerator(name="user_seq_gen",sequenceName = "user_seq", allocationSize = 1)
public class Users {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "planet_of_residency", nullable = false)
    private String planetOfResidency;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Users(){
        super();
    }

    public Users(String firstName, String lastName, String email, int phoneNumber, LocalDate birthDate, String password, String planetOfResidency, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.password = password;
        this.planetOfResidency = planetOfResidency;
        this.gender = gender;
    }

    public Users(int id, String firstName, String lastName, String email, int phoneNumber, LocalDate birthDate, String password, String planetOfResidency, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.password = password;
        this.planetOfResidency = planetOfResidency;
        this.gender = gender;
    }



    public Users(int id, String firstName, String lastName, String email, int phoneNumber, LocalDate birthDate, String password, String planetOfResidency, String gender, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
        Users users = (Users) o;
        return id == users.id &&
                phoneNumber == users.phoneNumber &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(lastName, users.lastName) &&
                Objects.equals(email, users.email) &&
                Objects.equals(birthDate, users.birthDate) &&
                Objects.equals(password, users.password) &&
                Objects.equals(planetOfResidency, users.planetOfResidency) &&
                Objects.equals(gender, users.gender) &&
                Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, birthDate, password, planetOfResidency, gender, role);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", planetOfResidency='" + planetOfResidency + '\'' +
                ", gender='" + gender + '\'' +
                ", role=" + role +
                '}';
    }
}
