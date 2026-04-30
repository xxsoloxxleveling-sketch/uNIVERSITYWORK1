package com.car.tracking.repository;

import com.car.tracking.model.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    void save(Vehicle vehicle);
    Optional<Vehicle> findByPlate(String plate);
    List<Vehicle> findAll();
}
