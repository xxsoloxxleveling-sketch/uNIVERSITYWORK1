package com.car.tracking.repository;

import com.car.tracking.model.Vehicle;
import java.util.*;

public class InMemoryVehicleRepo implements VehicleRepository {
    private Map<String, Vehicle> fleet = new HashMap<>();

    @Override
    public void save(Vehicle vehicle) { fleet.put(vehicle.getPlateNumber(), vehicle); }
    @Override
    public Optional<Vehicle> findByPlate(String plate) { return Optional.ofNullable(fleet.get(plate)); }
    @Override
    public List<Vehicle> findAll() { return new ArrayList<>(fleet.values()); }
}
