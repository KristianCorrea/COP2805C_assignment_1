package edu.mdc.cop2805c.assignment1.inventory;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.vehicles.*;

import java.io.*;
import java.util.*;

public class VehicleFileManager {
    public static void saveVehiclesToFile(List<Vehicle> vehicles, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> loadVehiclesFromFile(String filename) throws IOException{
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Vehicle vehicle = null;
                String[] parts = line.split(",");
                String vehicleType = parts[0];
                String vehicleSubType = parts[1];
                String VIN = parts[2];
                String make = parts[3];
                String model = parts[4];
                int year = Integer.parseInt(parts[5]);
                if (vehicleType.equals("Car") && vehicleSubType.equals("Fossil Fuel")) {
                    int weightKg = Integer.parseInt(parts[6]);
                    double engineDisplacementL = Double.parseDouble(parts[7]);
                    TransmissionType transmissionType = parts[8].equals("1") ? TransmissionType.AUTOMATIC : TransmissionType.MANUAL;
                    FossilFuelType fossilFuelType = parts[9].equals("1") ? FossilFuelType.GASOLINE : FossilFuelType.DIESEL;
                    vehicle = new FossilFuelCar(VIN, make, model, year, weightKg, engineDisplacementL, transmissionType, fossilFuelType);
                }
                if (vehicleType.equals("Car") && vehicleSubType.equals("Electric")) {
                    double electricityConsumedPerMilekWh = Double.parseDouble(parts[6]);
                    vehicle = new ElectricCar(VIN, make, model, year, electricityConsumedPerMilekWh);
                }
                if (vehicleType.equals("Truck") && vehicleSubType.equals("Fossil Fuel")) {
                    int grossVehicleWeightRatingTon = Integer.parseInt(parts[6]);
                    double engineDisplacementL = Double.parseDouble(parts[7]);
                    FossilFuelType fossilFuelType = parts[8].equals("1") ? FossilFuelType.GASOLINE : FossilFuelType.DIESEL;
                    vehicle = new FossilFuelTruck(make, VIN, model, year, grossVehicleWeightRatingTon, engineDisplacementL, fossilFuelType);
                }
                if (vehicleType.equals("Motorcycle") && vehicleSubType.equals("Fossil Fuel")) {
                    int weightKg = Integer.parseInt(parts[6]);
                    double engineDisplacementCC = Double.parseDouble(parts[7]);
                    double frontalAreaSqM = Double.parseDouble(parts[8]);
                    vehicle = new FossilFuelMotorcycle(VIN, make, model, year, weightKg, engineDisplacementCC, frontalAreaSqM);
                }
                if (vehicle != null){
                    vehicles.add(vehicle);
                }
            }
        }
        return vehicles;
    }
}
