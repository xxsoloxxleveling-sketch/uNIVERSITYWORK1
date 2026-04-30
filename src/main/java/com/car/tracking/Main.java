package com.car.tracking;

import com.car.tracking.repository.InMemoryVehicleRepo;
import com.car.tracking.service.*;
import com.car.tracking.util.LoggerUtil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InMemoryVehicleRepo repo = new InMemoryVehicleRepo();
        FleetManager fleetManager = new FleetManager(repo);
        TrackingService trackingService = new TrackingServiceImpl(repo);
        Scanner scanner = new Scanner(System.in);

        // Seed
        fleetManager.addVehicle("ABC-123", "Tesla Model 3");
        fleetManager.addVehicle("XYZ-789", "Ford F-150");
        
        // Add initial tracking points so history isn't empty
        trackingService.updateVehicleLocation("ABC-123", 40.7128, -74.0060);
        trackingService.updateVehicleLocation("XYZ-789", 34.0522, -118.2437);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Car Tracking System ---");
            System.out.println("1. Update Location");
            System.out.println("2. Show Fleet");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Select: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("Plate: "); String p = scanner.nextLine();
                    System.out.print("Lat: "); double lat = Double.parseDouble(scanner.nextLine());
                    System.out.print("Lon: "); double lon = Double.parseDouble(scanner.nextLine());
                    trackingService.updateVehicleLocation(p, lat, lon);
                }
                case "2" -> fleetManager.showFleet();
                case "3" -> {
                    System.out.print("Plate: "); String p = scanner.nextLine();
                    trackingService.printVehicleHistory(p);
                }
                case "4" -> exit = true;
                default -> LoggerUtil.log("Invalid option!");
            }
        }
        System.out.println("Shutting down tracker...");
        scanner.close();
    }
}
