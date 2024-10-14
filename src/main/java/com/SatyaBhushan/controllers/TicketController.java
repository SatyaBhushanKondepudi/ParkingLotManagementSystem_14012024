package com.SatyaBhushan.controllers;

import com.SatyaBhushan.dtos.Ticket.GenerateTicketRequestDto;
import com.SatyaBhushan.dtos.Ticket.GenerateTicketResponseDto;
import com.SatyaBhushan.dtos.Ticket.ResponseStatus;
import com.SatyaBhushan.exceptions.InvalidGateException;
import com.SatyaBhushan.exceptions.NoAvailableSpotException;
import com.SatyaBhushan.models.Ticket;
import com.SatyaBhushan.models.VehicleType;
import com.SatyaBhushan.services.TicketService;

public class TicketController {
    private TicketService ticketService ;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService ;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request){
        //ParkingSpot ,Operator,
        String vehicleNumber = request.getVehicleNumber();
        VehicleType vehicleType = request.getVehicleType();
        Long gateId = request.getGateId();
        Ticket ticket = new Ticket();
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try{
            ticket = ticketService.generateTicket(gateId , vehicleType , vehicleNumber);
        }catch(InvalidGateException e){
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Gate ID is invalid");
            return responseDto ;
        }catch(NoAvailableSpotException e){
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("No parking spot is available");
            return responseDto;
        }
        responseDto.setTicketId(ticket.getId());
        responseDto.setOperatorName(ticket.getIssuedBy().getName());
        responseDto.setSpotNumber(ticket.getParkingSpot().getSpotNumber());
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDto;
    }
}
