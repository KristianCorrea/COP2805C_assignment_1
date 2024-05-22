package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle;

public class ElectricCar extends Vehicle implements ElectricVehicle{
    double electricityConsumedPerMilekWh;

    //constructor
    public ElectricCar(String VIN, String make, String model, int year, double electricityConsumedPerMilekWh) {
        this.VIN=VIN;
        this.make=make;
        this.model=model;
        this.year=year;
        this.electricityConsumedPerMilekWh = electricityConsumedPerMilekWh;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public String getVehicleSubType() {
        return "Electric";
    }

    @Override
    public String getDescription() {
        return "Type: " + getVehicleType() + ", Subtype: " + getVehicleSubType() + ", Make: " + make + ", VIN: "+VIN+", Model: " + model + ", Year: " + year + ", Electricity Consumed Per Mile: " + electricityConsumedPerMilekWh + " kWh";
    }
    @Override
    public double estimateFuelEfficiencyEquivalent() {
        double equivalencyFactor = 33.7; // Equivalency factor in kWh/gallon
        double MPGe = equivalencyFactor / this.electricityConsumedPerMilekWh; // Fuel efficiency equivalent in MPGe
        return MPGe;
    }
    
}
