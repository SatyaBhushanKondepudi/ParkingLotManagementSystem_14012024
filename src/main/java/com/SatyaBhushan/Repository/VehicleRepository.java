package com.SatyaBhushan.Repository;

import com.SatyaBhushan.models.Vehicle;
import com.SatyaBhushan.models.VehicleType;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    Map<String, Vehicle> vehicleRepository = new TreeMap<>();

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber , VehicleType vehicleType) {
        if(!vehicleRepository.containsKey(vehicleNumber)){
            vehicleRepository.put(vehicleNumber , new Vehicle(vehicleNumber , vehicleType));
        }
        return Optional.of(vehicleRepository.get(vehicleNumber));
    }
}
