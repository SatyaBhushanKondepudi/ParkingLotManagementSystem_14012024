package com.SatyaBhushan.dtos.Bill;

import com.SatyaBhushan.dtos.Ticket.ResponseStatus;

import java.util.Date;

public class GenerateBillResponseDto {
    private String paymentLink ;
    private int amount ;
    private String OperationName ;
    private ResponseStatus responseStatus ;
    private String message ;

    public String getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOperationName() {
        return OperationName;
    }

    public void setOperationName(String operationName) {
        OperationName = operationName;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
