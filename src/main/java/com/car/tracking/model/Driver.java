package com.car.tracking.model;

public class Driver {
    private String id;
    private String name;
    private String licenseNumber;

    public Driver(String id, String name, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public String getName() { return name; }
    public String getId() { return id; }
}
