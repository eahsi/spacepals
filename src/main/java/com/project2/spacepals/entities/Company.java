package com.project2.spacepals.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="COMPANY")
@SequenceGenerator(name = "company_seq_gen",sequenceName = "company_seq",allocationSize = 1)
public class Company {

    @Id
    @Column(name="company_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="company_email")
    private String companyEmail;

    @Column(name="business_phone_number")
    private int businessPhoneNumber;

    @Column(name="planet_of_operations")
    private String planetOfOperations;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Users owner;

    public Company(){
        super();
    }

    public Company(String companyName, String companyEmail, int businessPhoneNumber, String planetOfOperations, Users owner) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.businessPhoneNumber = businessPhoneNumber;
        this.planetOfOperations = planetOfOperations;
        this.owner = owner;
    }

    public Company(int id, String companyName, String companyEmail, int businessPhoneNumber, String planetOfOperations, Users owner) {
        this.id = id;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.businessPhoneNumber = businessPhoneNumber;
        this.planetOfOperations = planetOfOperations;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public int getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(int businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getPlanetOfOperations() {
        return planetOfOperations;
    }

    public void setPlanetOfOperations(String planetOfOperations) {
        this.planetOfOperations = planetOfOperations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id &&
                businessPhoneNumber == company.businessPhoneNumber &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(companyEmail, company.companyEmail) &&
                Objects.equals(planetOfOperations, company.planetOfOperations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, companyEmail, businessPhoneNumber, planetOfOperations);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", businessPhoneNumber=" + businessPhoneNumber +
                ", planetOfOperations='" + planetOfOperations + '\'' +
                '}';
    }
}
