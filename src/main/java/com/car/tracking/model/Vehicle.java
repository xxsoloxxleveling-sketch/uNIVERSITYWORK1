package com.car.tracking.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String plateNumber;
    private String model;
    private GPSLocation currentLocation;
    private List<TrackLog> history;

    public Vehicle(String plateNumber, String model) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.history = new ArrayList<>();
    }

    public String getPlateNumber() { return plateNumber; }
    public String getModel() { return model; }
    public GPSLocation getCurrentLocation() { return currentLocation; }
    
    public void updateLocation(GPSLocation location) {
        this.currentLocation = location;
        this.history.add(new TrackLog(plateNumber, location));
    }

    public List<TrackLog> getHistory() { return history; }
}
