package com.SatyaBhushan.stratergies.feesCalculatorStratergy;

import com.SatyaBhushan.models.Ticket;
import com.SatyaBhushan.models.VehicleType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeekEndFeeCalculatorStrategy implements FeesCalculatorStrategy {

    /*
    Based on Parking time fee should vary
    Two wheelers - Four wheelers:
    9AM - 30RS/hr - 50RS/hr
    6PM - 40RS/hr - 60RS/hr
     */

    int amount = 0;
    @Override
    public int calculateFees(Ticket ticket) {
        LocalTime entryTime = ticket.getEntryTime().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();
        LocalTime exitTime = LocalTime.now();
        long hoursSpent = java.time.Duration.between(entryTime, exitTime).toHours();

        if (ticket.getVehicle().getVehicleType().equals(VehicleType.FOUR_WHEELER)) {
            if (entryTime.isBefore(LocalTime.of(18, 0))) {
                amount = 50;
            }else {
                amount = 60;
            }
        } else if (ticket.getVehicle().getVehicleType().equals(VehicleType.TWO_WHEELER)) {
            if (entryTime.isBefore(LocalTime.of(18, 0))) {
                amount = 30;
            } else {
                amount = 40;
            }
        }

        return amount * (int) hoursSpent;
    }
}
