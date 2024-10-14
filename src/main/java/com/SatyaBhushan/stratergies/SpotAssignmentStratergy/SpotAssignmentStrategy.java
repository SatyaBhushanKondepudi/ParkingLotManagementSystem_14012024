package com.SatyaBhushan.stratergies.SpotAssignmentStratergy;

import com.SatyaBhushan.models.Gate;
import com.SatyaBhushan.models.ParkingLot;
import com.SatyaBhushan.models.ParkingSpot;
import com.SatyaBhushan.models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType,
                                   ParkingLot parkingLot,
                                   Gate entryGate);

}
