package com.SatyaBhushan.services;

import com.SatyaBhushan.Repository.IGateRepository;
import com.SatyaBhushan.Repository.TicketRepository;
import com.SatyaBhushan.models.Bill;
import com.SatyaBhushan.models.Ticket;
import com.SatyaBhushan.stratergies.feesCalculatorStratergy.FeeCalculatorStrategyFactory;
import com.SatyaBhushan.stratergies.feesCalculatorStratergy.FeesCalculatorStrategy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class BillService {
    private TicketRepository ticketRepository;
    private IGateRepository gateRepository;
    public BillService(TicketRepository ticketRepository ,
                       IGateRepository gateRepository) {
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
    }
    /*
    Fee CalculationStategy
     */

    public Bill createBill(Long ticketId, Long gateId) {
        Bill bill = new Bill();
        //WeekDay[MON-FRI] , WeekEnd[SAT,SUN]
        Ticket ticket = ticketRepository.getTicket(ticketId);
        FeesCalculatorStrategy feesCalculatorStrategy =
                FeeCalculatorStrategyFactory.getFeeCalculatorStrategy(LocalDate.now().getDayOfWeek());
        bill.setAmount(feesCalculatorStrategy.calculateFees(ticket));
        bill.setTicket(ticket);
        bill.setExitGate(gateRepository.findGateById(gateId).get());
        bill.setExitTime(new Date());
        return bill ;
    }
}
