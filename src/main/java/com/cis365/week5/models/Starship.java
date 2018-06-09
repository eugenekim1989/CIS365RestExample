package com.cis365.week5.models;

import javax.persistence.*;

@Entity
@Table(name = "STARSHIP")
public class Starship {



    public Starship(){}

    @Id
    @Column(name = "STARSHIPID")
    private String starShipId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREWSIZE")
    private int crewSize;

    @Column(name = "SHIPCLASS")
    private String shipClass;

    @Column(name = "LAUNCHSTARDATE")
    private int launchStarDate;

    public String getStarShipId() {
        return starShipId;
    }

    public void setStarShipId(String starShipId) {
        this.starShipId = starShipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public String getShipClass() {
        return shipClass;
    }

    public void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }

    public int getLaunchStarDate() {
        return launchStarDate;
    }

    public void setLaunchStarDate(int launchStarDate) {
        this.launchStarDate = launchStarDate;
    }
}
