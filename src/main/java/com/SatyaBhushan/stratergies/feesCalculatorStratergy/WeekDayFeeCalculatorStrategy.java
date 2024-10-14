package com.SatyaBhushan.stratergies.feesCalculatorStratergy;

import com.SatyaBhushan.models.Ticket;
import com.SatyaBhushan.models.VehicleType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeekDayFeeCalculatorStrategy implements FeesCalculatorStrategy{
    /*
    Based on Parking time fee should vary
    Two wheelers - Four wheelers:
    9AM - 30RS/hr - 50RS/hr
    1PM - 40RS/hr - 60RS/hr
    6PM - 50RS/hr - 70RS/hr
     */

    int amount = 0;
    @Override
    public int calculateFees(Ticket ticket) {
        LocalTime entryTime = ticket.getEntryTime().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();
        LocalTime exitTime = LocalTime.now();
        long hoursSpent = java.time.Duration.between(entryTime, exitTime).toHours();

        if (ticket.getVehicle().getVehicleType().equals(VehicleType.FOUR_WHEELER)) {
            if (entryTime.isBefore(LocalTime.of(13, 0))) {
                amount = 50;
            } else if (entryTime.isBefore(LocalTime.of(18, 0))) {
                amount = 60;
            } else {
                amount = 70;
            }
        } else if (ticket.getVehicle().getVehicleType().equals(VehicleType.TWO_WHEELER)) {
            if (entryTime.isBefore(LocalTime.of(13, 0))) {
                amount = 30;
            } else if (entryTime.isBefore(LocalTime.of(18, 0))) {
                amount = 40;
            } else {
                amount = 50;
            }
        }

        return amount * (int) hoursSpent;
    }

}
