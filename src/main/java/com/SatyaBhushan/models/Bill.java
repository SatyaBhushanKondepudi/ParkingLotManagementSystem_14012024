package com.SatyaBhushan.models;

import java.util.Date;

public class Bill extends BaseModel{
    private Date exitTime ;
    private Ticket ticket ;
    private Operator issuedByOperator ;
    private int amount ;
    private Gate exitGate ;
//    private String paymentLink ;


    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getIssuedByOperator() {
        return issuedByOperator;
    }

    public void setIssuedByOperator(Operator issuedByOperator) {
        this.issuedByOperator = issuedByOperator;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
