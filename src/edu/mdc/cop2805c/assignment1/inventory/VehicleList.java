package edu.mdc.cop2805c.assignment1.inventory;

import java.util.ArrayList;
import java.util.List;

import edu.mdc.cop2805c.assignment1.base.Vehicle;

public class VehicleList {
    private List<Vehicle> vehicles;

    // Constructor that creates an empty list
    public VehicleList() {
        vehicles = new ArrayList<>();
    }

    // Constructor that loads vehicles from a Text file
    public VehicleList(String filename) {
        vehicles = new ArrayList<>();
        try {
            vehicles = VehicleFileManager.loadVehiclesFromFile(filename);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading vehicles from file:" + filename);
            System.out.println(filename + "not found. No existing vehicles loaded.");
            this.vehicles = new ArrayList<>();
        }
    }

    // Add a vehicle to the list
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Remove a vehicle from the list
    public void removeVehicle(int index) {
        vehicles.remove(index);
    }

    // Get the list of vehicles
    public List<Vehicle> getVehicles() {
        return vehicles;
        // return new ArrayList<>(vehicles);
    }

    // Get Vehicles by Type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equals(vehicleType)) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    // Save Vehicles to File
    public void saveToFile(String filename) {
        VehicleFileManager.saveVehiclesToFile(vehicles, filename);
    }
}
