package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    public Customer(){}

    @Id
    @Column(name = "CUSTOMER_NUM")
    private String id;

    @Column(name = "CUSTOMER_NAME")
    private String custmomerName;

    @Column(name = "STREET")
    private String streetAddress;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zipcode;

    @Column(name = "BALANCE")
    private double balance;

    @Column(name = "CREDIT_LIMIT")
    private double creditLimit;

    @Column(name = "REP_NUM")
    private String repNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustmomerName() {
        return custmomerName;
    }

    public void setCustmomerName(String custmomerName) {
        this.custmomerName = custmomerName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getRepNum() {
        return repNum;
    }

    public void setRepNum(String repNum) {
        this.repNum = repNum;
    }



}
