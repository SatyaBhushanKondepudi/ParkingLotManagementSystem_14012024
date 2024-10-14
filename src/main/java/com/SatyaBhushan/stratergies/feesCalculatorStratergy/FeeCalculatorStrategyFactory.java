package com.SatyaBhushan.stratergies.feesCalculatorStratergy;

import com.SatyaBhushan.models.Day;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FeeCalculatorStrategyFactory {
    public static FeesCalculatorStrategy getFeeCalculatorStrategy(DayOfWeek dayofTheWeek){
        if(dayofTheWeek.equals(DayOfWeek.SATURDAY) || dayofTheWeek.equals(DayOfWeek.SUNDAY) ){
            return new WeekEndFeeCalculatorStrategy();
        }else{
            return new WeekDayFeeCalculatorStrategy();
        }
    }
}
