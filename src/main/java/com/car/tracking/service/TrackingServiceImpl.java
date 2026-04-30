package com.car.tracking.service;

import com.car.tracking.model.*;
import com.car.tracking.repository.VehicleRepository;
import com.car.tracking.util.LoggerUtil;

public class TrackingServiceImpl implements TrackingService {
    private VehicleRepository repository;

    public TrackingServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void updateVehicleLocation(String plate, double lat, double lon) {
        repository.findByPlate(plate).ifPresent(v -> {
            v.updateLocation(new GPSLocation(lat, lon, System.currentTimeMillis()));
            LoggerUtil.log("Updated location for " + plate);
        });
    }

    @Override
    public void printVehicleHistory(String plate) {
        repository.findByPlate(plate).ifPresentOrElse(v -> {
            System.out.println("History for " + plate + ":");
            if (v.getHistory().isEmpty()) {
                System.out.println("  > No tracking history found.");
            } else {
                v.getHistory().forEach(System.out::println);
            }
        }, () -> System.out.println("Vehicle not found."));
    }
}
