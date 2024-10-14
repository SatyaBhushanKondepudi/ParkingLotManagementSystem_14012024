package com.SatyaBhushan.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private ParkingSpot parkingSpot ;
    private Date entryTime ;
    private Vehicle vehicle  ;
    private Gate entryGate ;
    private Operator issuedBy ;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Operator getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(Operator issuedBy) {
        this.issuedBy = issuedBy;
    }
}
