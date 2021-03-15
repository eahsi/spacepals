package com.project2.spacepals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project2.spacepals.web.dtos.Principal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Planet residency;

    @Column(name = "gender")
    private String gender;

    @Column
    private int frequentFlyerPoints;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @JoinColumn
//    @JoinTable(
//            name="user_companies",
//            joinColumns=@JoinColumn(name="user_id"),
//            inverseJoinColumns=@JoinColumn(name="company_id")
//    )
    @OneToMany
    @Fetch(FetchMode.JOIN)
    private List<Company> companies;

    public User(){
        super();
    }

    public User(String firstName, String lastName, String email, String password, Planet residency, String gender, int frequentFlyerPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.residency = residency;
        this.gender = gender;
        this.frequentFlyerPoints = frequentFlyerPoints;
    }

    public User(String firstName, String lastName, String email, String password, Planet residency, String gender, int frequentFlyerPoints, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.residency = residency;
        this.gender = gender;
        this.frequentFlyerPoints = frequentFlyerPoints;
        this.role = role;
    }

    public User(int id, String firstName, String lastName, String email, String password, Planet residency, String gender, int frequentFlyerPoints, Role role, List<Company> companies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.residency = residency;
        this.gender = gender;
        this.frequentFlyerPoints = frequentFlyerPoints;
        this.role = role;
        this.companies = companies;
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

    public Planet getResidency() {
        return residency;
    }

    public void setResidency(Planet residency) {
        this.residency = residency;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFrequentFlyerPoints() {
        return frequentFlyerPoints;
    }

    public void setFrequentFlyerPoints(int frequentFlyerPoints) {
        this.frequentFlyerPoints = frequentFlyerPoints;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public void addCompany(Company comp){
        if(companies == null) companies = new ArrayList<>();
        //comp.setManager(this);
        companies.add(comp);
    }

    public Principal extractPrincipal() {
        return new Principal(this.id, this.email, this.role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getFrequentFlyerPoints() == user.getFrequentFlyerPoints() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getResidency(), user.getResidency()) &&
                Objects.equals(getGender(), user.getGender()) &&
                getRole() == user.getRole() &&
                Objects.equals(getCompanies(), user.getCompanies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getResidency(), getGender(), getFrequentFlyerPoints(), getRole(), getCompanies());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", residency=" + residency +
                ", gender='" + gender + '\'' +
                ", frequentFlyerPoints=" + frequentFlyerPoints +
                ", role=" + role +
                ", company=" + companies +
                '}';
    }
}
