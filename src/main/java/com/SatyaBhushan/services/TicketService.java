package com.SatyaBhushan.services;

import com.SatyaBhushan.Repository.*;
import com.SatyaBhushan.exceptions.InvalidGateException;
import com.SatyaBhushan.exceptions.NoAvailableSpotException;
import com.SatyaBhushan.models.*;
import com.SatyaBhushan.stratergies.SpotAssignmentStratergy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private IGateRepository gateRepository;
    private VehicleRepository vehicleRepository ;
    private SpotAssignmentStrategy spotAssignmentStrategy ;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository ;

    public TicketService(IGateRepository gateRepository  ,
                         VehicleRepository vehicleRepository ,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository = gateRepository ;
        this.vehicleRepository = vehicleRepository ;
        this.spotAssignmentStrategy = spotAssignmentStrategy ;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository ;
    }

    public Ticket generateTicket(Long gateId,
                                 VehicleType vehicleType,
                                 String vehicleNumber)
            throws InvalidGateException, NoAvailableSpotException {
        /*
        Gate = get gate for that id from db. Else throw an exception
        Operator = from gate
        Vehicle = check if already in DB. If yes, get that. Else, create
        ParkingSpot = strategy
        Ticket ticket =
         */

//        Check if Gate exists in the GateRepository
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
//        NotExists - InvalidGateException
        if (gateOptional.isEmpty()) {
            throw new InvalidGateException();
        }
//      If Exists Get It
        Gate gate = gateOptional.get();
//        Check the currentOperator at the gate
        Operator currentOperator = gate.getCurrentOperator();
//        Check the VehicleRepository if the vehicle exists or not
//        If Exists - Return it . Else save it is Vehicle Repository
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber,vehicleType);
        Vehicle vehicle = vehicleOptional.get();

//        Check the Parkinglotrelated to the gate
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotOfGate(gate);
        if(parkingLotOptional.isEmpty()){
            throw new RuntimeException();
        }
//        Use the Spot Assignment Stratergy to allocate a ParkingSpot
        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.findSpot(
                vehicleType, parkingLotOptional.get(), gate);
        if(parkingSpotOptional.isEmpty())
            throw new NoAvailableSpotException();
        ParkingSpot parkingSpot = parkingSpotOptional.get();

//        Generate a Ticket & save it to Ticket Repository
        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setIssuedBy(currentOperator);

        return ticketRepository.save(ticket);
    }
}
