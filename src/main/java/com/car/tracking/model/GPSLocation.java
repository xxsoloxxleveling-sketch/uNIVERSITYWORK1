package com.car.tracking.model;

public record GPSLocation(double latitude, double longitude, long timestamp) {
    @Override
    public String toString() {
        return String.format("(%.4f, %.4f) at %d", latitude, longitude, timestamp);
    }
}
