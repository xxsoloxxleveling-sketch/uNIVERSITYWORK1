package com.car.tracking.service;

import com.car.tracking.model.GPSLocation;

public interface TrackingService {
    void updateVehicleLocation(String plate, double lat, double lon);
    void printVehicleHistory(String plate);
}
