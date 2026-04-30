package com.car.tracking.model;

import java.time.LocalDateTime;

public class TrackLog {
    private String vehicleId;
    private GPSLocation location;
    private LocalDateTime logTime;

    public TrackLog(String vehicleId, GPSLocation location) {
        this.vehicleId = vehicleId;
        this.location = location;
        this.logTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] Vehicle %s at %s", logTime, vehicleId, location);
    }
}
