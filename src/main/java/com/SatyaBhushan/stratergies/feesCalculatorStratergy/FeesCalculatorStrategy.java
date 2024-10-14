package com.SatyaBhushan.stratergies.feesCalculatorStratergy;

import com.SatyaBhushan.models.Ticket;
import com.SatyaBhushan.models.VehicleType;

import java.time.DayOfWeek;

public interface FeesCalculatorStrategy {

    int calculateFees(Ticket ticket);
}
