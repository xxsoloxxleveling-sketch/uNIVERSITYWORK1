package com.car.tracking.service;

import com.car.tracking.model.Vehicle;
import com.car.tracking.repository.VehicleRepository;
import com.car.tracking.util.LoggerUtil;

public class FleetManager {
    private VehicleRepository repository;

    public FleetManager(VehicleRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(String plate, String model) {
        repository.save(new Vehicle(plate, model));
        LoggerUtil.log("Added vehicle to fleet: " + plate);
    }

    public void showFleet() {
        LoggerUtil.log("Current Fleet Status:");
        repository.findAll().forEach(v -> 
            System.out.println(v.getPlateNumber() + " (" + v.getModel() + ") - Last: " + v.getCurrentLocation()));
    }
}
