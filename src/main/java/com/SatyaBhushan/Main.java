package com.SatyaBhushan;

import com.SatyaBhushan.Repository.GateRepository;
import com.SatyaBhushan.Repository.ParkingLotRepository;
import com.SatyaBhushan.Repository.TicketRepository;
import com.SatyaBhushan.Repository.VehicleRepository;
import com.SatyaBhushan.controllers.TicketController;
import com.SatyaBhushan.services.TicketService;
import com.SatyaBhushan.stratergies.SpotAssignmentStratergy.RandomParkingSpotAssignmentStrategy;
import com.SatyaBhushan.stratergies.SpotAssignmentStratergy.SpotAssignmentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomParkingSpotAssignmentStrategy();


        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssignmentStrategy,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Application has started on part :8080");

    }
}