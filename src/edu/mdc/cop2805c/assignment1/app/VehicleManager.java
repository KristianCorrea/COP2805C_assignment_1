package edu.mdc.cop2805c.assignment1.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;
import edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager;
import edu.mdc.cop2805c.assignment1.inventory.VehicleList;
import edu.mdc.cop2805c.assignment1.vehicles.*;

public class VehicleManager {
    public static void main(String[] args) throws Exception {
        VehicleList vehicleList = new VehicleList("vehicles.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View all vehicles");
            System.out.println("2. View vehicles by type");
            System.out.println("3. Add a new vehicle");
            System.out.println("4. Remove an existing vehicle");
            System.out.println("5. Display fuel efficiency and/or emissions for a vehicle");
            System.out.println("6. Display fuel efficiency and/or emissions for a vehicle type");
            System.out.println("7. Display fuel efficiency and/or emissions for all vehicles");
            System.out.println("Q. Exit the program");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewAllVehicles(vehicleList);
                    break;
                case "2":
                    viewVehiclesByType(vehicleList, scanner);
                    break;
                case "3":
                    addNewVehicle(vehicleList, scanner);
                    break;
                case "4":
                    removeVehicle(vehicleList, scanner);
                    break;
                case "5":
                    displayEfficiencyOrEmissionsForVehicle(vehicleList, scanner);
                    break;
                case "6":
                    displayEfficiencyOrEmissionsForVehicleType(vehicleList, scanner);
                    break;
                case "7":
                    displayEfficiencyOrEmissionsForAllVehicles(vehicleList);
                    break;
                case "Q":
                case "q":
                    vehicleList.saveToFile("vehicles.txt");
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        

    }

    private static void viewAllVehicles(VehicleList vehicleList) {
        List<Vehicle> vehicles = vehicleList.getVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getDescription());
        }
    }

    private static void viewVehiclesByType(VehicleList vehicleList, Scanner scanner) {
        System.out.print("Enter the vehicle type (Car, Truck, Motorcycle): ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = vehicleList.getVehiclesByType(vehicleType);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getDescription());
        }
    }

    private static void addNewVehicle(VehicleList vehicleList, Scanner scanner) {
        System.out.print("Enter the vehicle type (Car, Truck, Motorcycle): ");
        String vehicleType = scanner.nextLine();
        String vehicleSubType = "";
        // Truck and MotorCycle have a default Subtype of "Fossil Fuel"
        if (vehicleType.equals("Car")) {
            System.out.print("Enter the vehicle subtype (Fossil Fuel, Electric): ");
            vehicleSubType = scanner.nextLine();
        } else {
            vehicleSubType = "Fossil Fuel";
        }
        
        System.out.print("Enter the VIN: ");
        String VIN = scanner.nextLine();
        System.out.print("Enter the make: ");
        String make = scanner.nextLine();
        System.out.print("Enter the model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());

        if (vehicleType.equals("Car") && vehicleSubType.equals("Fossil Fuel")) {
            System.out.print("Enter the weight in Kg: ");
            int weightKg = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the engine displacement in Liters: ");
            double engineDisplacementL = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the transmission type (1 for Automatic, 2 for Manual): ");
            TransmissionType transmissionType = scanner.nextLine().equals("1") ? TransmissionType.AUTOMATIC : TransmissionType.MANUAL;
            System.out.print("Enter the fuel type (1 for Gasoline, 2 for Diesel): ");
            FossilFuelType fossilFuelType = scanner.nextLine().equals("1") ? FossilFuelType.GASOLINE : FossilFuelType.DIESEL;
            vehicleList.addVehicle(new FossilFuelCar(VIN, make, model, year, weightKg, engineDisplacementL, transmissionType, fossilFuelType));
            System.out.println("Vehicle added successfully.");
            return;
        }
        if (vehicleType.equals("Car") && vehicleSubType.equals("Electric")) {
            System.out.print("Enter the electricity consumed per mile in kWh: ");
            double electricityConsumedPerMilekWh = Double.parseDouble(scanner.nextLine());
            vehicleList.addVehicle(new ElectricCar(VIN, make, model, year, electricityConsumedPerMilekWh));
            System.out.println("Vehicle added successfully.");
            return;
        }
        if (vehicleType.equals("Truck") && vehicleSubType.equals("Fossil Fuel")) {
            System.out.print("Enter the gross vehicle weight rating in Tons: ");
            int grossVehicleWeightRatingTon = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the engine displacement in Liters: ");
            double engineDisplacementL = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the fuel type (1 for Gasoline, 2 for Diesel): ");
            FossilFuelType fossilFuelType = scanner.nextLine().equals("1") ? FossilFuelType.GASOLINE : FossilFuelType.DIESEL;
            vehicleList.addVehicle(new FossilFuelTruck(make, VIN, model, year, grossVehicleWeightRatingTon, engineDisplacementL, fossilFuelType));
            System.out.println("Vehicle added successfully.");
            return;
        }
        if (vehicleType.equals("Motorcycle") && vehicleSubType.equals("Fossil Fuel")) {
            System.out.print("Enter the weight in Kg: ");
            int weightKg = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the engine displacement in CC: ");
            double engineDisplacementCC = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the frontal area in square meters: ");
            double frontalAreaSqM = Double.parseDouble(scanner.nextLine());
            vehicleList.addVehicle(new FossilFuelMotorcycle(VIN, make, model, year, weightKg, engineDisplacementCC, frontalAreaSqM));

            System.out.println("Vehicle added successfully.");
            return;
        }

        System.out.println("Failed to add Vehicle.");
    }
    //For the "Remove an existing vehicle" option, display a list of all vehicles currently in the VehicleList and prompt the user to select a vehicle to remove.
    private static void removeVehicle(VehicleList vehicleList, Scanner scanner) {
        List<Vehicle> vehicles = vehicleList.getVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(i+1 + ". " + vehicles.get(i).getDescription());
        }
        System.out.print("Enter the number of the vehicle to remove: ");
        int index = Integer.parseInt(scanner.nextLine())-1;
        vehicleList.removeVehicle(index);
        System.out.println("Vehicle removed successfully.");
    }

    //For the "Calculate fuel efficiency" and "Calculate emissions" options, display a list of all vehicles currently in the VehicleList and prompt the user to select a vehicle. Then, calculate and display the fuel efficiency or emissions for the selected vehicle using the corresponding methods from the vehicle class.

    private static void displayEfficiencyOrEmissionsForVehicle(VehicleList vehicleList, Scanner scanner) {
        List<Vehicle> vehicles = vehicleList.getVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(i+1 + ". " + vehicles.get(i).getDescription());
        }
        System.out.print("Enter the number of the vehicle to display fuel efficiency and/or emissions: ");
        int index = Integer.parseInt(scanner.nextLine())-1;
        Vehicle vehicle = vehicles.get(index);
        if (vehicle instanceof ElectricVehicle) {
            ElectricVehicle ev = (ElectricVehicle) vehicle;

            System.out.println("\tFuel Efficiency Equivalent: " + ev.estimateFuelEfficiencyEquivalent());
        } else if (vehicle instanceof FossilFuelVehicle) {
            FossilFuelVehicle ffv = (FossilFuelVehicle) vehicle;

            System.out.println(
                    String.format("\tFuel Efficiency (MPG): %f\n\tCO2 Emissions (g/mile): %f\n\tNOx Emissions: %f",
                            ffv.estimateFuelEfficiency(),
                            ffv.estimateCO2Emissions(),
                            ffv.estimateNOxEmissions()));
        }
    }

    private static void displayEfficiencyOrEmissionsForVehicleType(VehicleList vehicleList, Scanner scanner) {
        System.out.print("Enter the vehicle type (Car, Truck, Motorcycle): ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = vehicleList.getVehiclesByType(vehicleType);
        for (Vehicle vehicle : vehicles) {
            // Display vehicle description
            System.out.println(vehicle.getDescription());
            if (vehicle instanceof ElectricVehicle) {
                ElectricVehicle ev = (ElectricVehicle) vehicle;

                System.out.println("\tFuel Efficiency Equivalent: " + ev.estimateFuelEfficiencyEquivalent());
            } else if (vehicle instanceof FossilFuelVehicle) {
                FossilFuelVehicle ffv = (FossilFuelVehicle) vehicle;

                System.out.println(
                        String.format("\tFuel Efficiency (MPG): %f\n\tCO2 Emissions (g/mile): %f\n\tNOx Emissions: %f",
                                ffv.estimateFuelEfficiency(),
                                ffv.estimateCO2Emissions(),
                                ffv.estimateNOxEmissions()));
            }
        }
    }

    private static void displayEfficiencyOrEmissionsForAllVehicles(VehicleList vehicleList) {
        List<Vehicle> vehicles = vehicleList.getVehicles();
        for (Vehicle vehicle : vehicles) {
            // Display vehicle description
            System.out.println(vehicle.getDescription());
            if (vehicle instanceof ElectricVehicle) {
                ElectricVehicle ev = (ElectricVehicle) vehicle;

                System.out.println("\tFuel Efficiency Equivalent: " + ev.estimateFuelEfficiencyEquivalent());
            } else if (vehicle instanceof FossilFuelVehicle) {
                FossilFuelVehicle ffv = (FossilFuelVehicle) vehicle;

                System.out.println(
                        String.format("\tFuel Efficiency (MPG): %f\n\tCO2 Emissions (g/mile): %f\n\tNOx Emissions: %f",
                                ffv.estimateFuelEfficiency(),
                                ffv.estimateCO2Emissions(),
                                ffv.estimateNOxEmissions()));
            }
        }
    }
}
