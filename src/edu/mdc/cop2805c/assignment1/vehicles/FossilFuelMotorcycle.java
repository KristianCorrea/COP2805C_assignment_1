package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelMotorcycle extends Vehicle implements FossilFuelVehicle{
    int weightKg;
    double engineDisplacementCC; //cubic centimeters
    double frontalAreaSqM; //Frontal Area of Motorcycle in square meters

    final int CO2_MOTORCYCLE_EMISSION_FACTOR = 4600;
    final double NOX_MOTORCYCLE_EMISSION_FACTOR = 3.20;

    //constructor
    public FossilFuelMotorcycle(String VIN, String make, String model, int year, int weightKg, double engineDisplacementCC, double frontalAreaSqM){
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.weightKg = weightKg;
        this.engineDisplacementCC = engineDisplacementCC;
        this.frontalAreaSqM = frontalAreaSqM;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
    @Override
    public String getVehicleSubType() {
        return "Fossil Fuel";
    }
    @Override
    public String getDescription() {
        return "Model: "+model+", Make: "+make+", Type: "+getVehicleType()+", SubType: "+getVehicleSubType()+", VIN: "+VIN+", Year: "+year+", Weight: "+weightKg+"Kg, Engine Displacement: "+engineDisplacementCC+"CC, Frontal Area: "+frontalAreaSqM+"sqm";
    }

    @Override
    public String toFileFormat() {
        return super.toFileFormat()+","+weightKg+","+engineDisplacementCC+","+frontalAreaSqM;
    }

    @Override
    public double estimateFuelEfficiency() {
        double W = this.weightKg; // Vehicle weight in kilograms
        double D = this.engineDisplacementCC; // Engine displacement in cubic centimeters
        double Cd = 0.35; // Drag coefficient
        double A = this.frontalAreaSqM; // Frontal area in square meters

        double FE = (46.64 - (0.0039 * W) - (0.008 * D)) / (Cd * A); // Fuel efficiency in mpg
        return FE;
    }

    @Override
    public double estimateCO2Emissions() {
        double EF = CO2_MOTORCYCLE_EMISSION_FACTOR; // Emission factor for CO2
        double FE = estimateFuelEfficiency(); // Fuel efficiency
        double emissions = FE * EF; // Emissions in grams/mile
        return emissions;
    }

    @Override
    public double estimateNOxEmissions() {
        double EF = NOX_MOTORCYCLE_EMISSION_FACTOR; // Emission factor for NOx
        double FE = estimateFuelEfficiency(); // Fuel efficiency
        double emissions = FE * EF; // Emissions in grams/mile
        return emissions;
    }
}
