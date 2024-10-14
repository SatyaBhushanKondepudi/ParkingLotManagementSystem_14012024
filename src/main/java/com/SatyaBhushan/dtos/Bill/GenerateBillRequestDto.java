package com.SatyaBhushan.dtos.Bill;

public class GenerateBillRequestDto {
    private Long exitGateId ;
    private Long ticketId ;

    public Long getExitGateId() {
        return exitGateId;
    }

    public void setExitGateId(Long exitGateId) {
        this.exitGateId = exitGateId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}
