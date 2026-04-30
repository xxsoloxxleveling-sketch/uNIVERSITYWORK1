package com.car.tracking.util;

import com.car.tracking.model.GPSLocation;

public class DistanceCalculator {
    public static double calculateDistance(GPSLocation loc1, GPSLocation loc2) {
        // Simple Euclidean distance for demonstration
        double dLat = loc1.latitude() - loc2.latitude();
        double dLon = loc1.longitude() - loc2.longitude();
        return Math.sqrt(dLat * dLat + dLon * dLon) * 111.0; // Approx km
    }
}
