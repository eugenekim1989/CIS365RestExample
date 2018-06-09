package com.cis365.week5.models;

import javax.persistence.*;


/**
 *
 * @author Eugene
 */
@Entity
@Table(name="PLANETVISIT")
public class PlanetVisit {
    
    public PlanetVisit(){}
    
    @Id //id as primary key
    @Column(name = "PLANETID")
    private int planetId;
    
    @Id
    @Column(name = "STARSHIPID")
    private int starshipID;
    
    @Id
    @Column(name = "ARRIVALSTARDATE")
    private int arrivalStardate;
    
    @Column(name = "DEPARTURESTARDATE")
    private int departureStardate;

    public int getPlanetId() {
        return planetId;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public int getStarshipID() {
        return starshipID;
    }

    public void setStarshipID(int starshipID) {
        this.starshipID = starshipID;
    }

    public int getArrivalStardate() {
        return arrivalStardate;
    }

    public void setArrivalStardate(int arrivalStardate) {
        this.arrivalStardate = arrivalStardate;
    }

    public int getDepartureStardate() {
        return departureStardate;
    }

    public void setDepartureStardate(int departureStardate) {
        this.departureStardate = departureStardate;
    }
    
}
