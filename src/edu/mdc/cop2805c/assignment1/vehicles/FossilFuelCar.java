package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelCar extends Vehicle implements FossilFuelVehicle{
    int weightKg;   // Kilograms
    double engineDisplacementL; // Liters
    TransmissionType transmissionType;
    FossilFuelType fossilFuelType;

    final int CO2_GASOLINE_CAR_EMISSION_FACTOR = 8887;
    final int CO2_DIESEL_CAR_EMISSION_FACTOR = 8260;
    final double NOX_GASOLINE_CAR_EMISSION_FACTOR = 0.68;
    final double NOX_DIESEL_CAR_EMISSION_FACTOR = 2.01;

    //constructor
    public FossilFuelCar(String VIN, String make, String model, int year, int weightKg, double engineDisplacementL, TransmissionType transmissionType, FossilFuelType fossileFuelType){
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.weightKg = weightKg;
        this.engineDisplacementL = engineDisplacementL;
        this.transmissionType = transmissionType;
        this.fossilFuelType = fossileFuelType;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public String getVehicleSubType() {
        return "Fossil Fuel";
    }

    @Override
    public String getDescription() {
        return "Type: "+getVehicleType()+", SubType: "+getVehicleSubType()+", Make: "+make+", VIN: "+VIN+", Model: "+model+", Year: "+year+", Weight: "+weightKg+"Kg, Engine Displacement: "+engineDisplacementL+"L, Transmission: "+transmissionType+", Fuel Type: "+fossilFuelType;
    }
    
    @Override
    public double estimateFuelEfficiency() {
        double C = 0.5; // Drag coefficient
        double D = this.engineDisplacementL; // Engine displacement in liters
        double W = this.weightKg; // Weight in kilograms
        double T;
        if (this.transmissionType == TransmissionType.AUTOMATIC) {
            T = 1;
        } else {
            T = 0.8;
        }
        double FE = (C * Math.pow(D, 2.5)) / (Math.pow(W, 0.6) * T) * 1000;
        return FE;
    }

    @Override
    public double estimateCO2Emissions() {
        double EF; // Emission factor for CO2
    
        switch (this.fossilFuelType) {
            case GASOLINE:
                EF = CO2_GASOLINE_CAR_EMISSION_FACTOR;
                break;
            case DIESEL:
                EF = CO2_DIESEL_CAR_EMISSION_FACTOR;
                break;
            default:
                throw new IllegalArgumentException("Invalid fuel type");
        }
    
        double FE = estimateFuelEfficiency(); // Fuel efficiency
        double emissions = FE * EF; // Emissions in grams/mile
        return emissions;
    }

    @Override
    public double estimateNOxEmissions() {
        double EF; // Emission factor for NOx
    
        switch (this.fossilFuelType) {
            case GASOLINE:
                EF = NOX_GASOLINE_CAR_EMISSION_FACTOR;
                break;
            case DIESEL:
                EF = NOX_DIESEL_CAR_EMISSION_FACTOR;
                break;
            default:
                throw new IllegalArgumentException("Invalid fuel type");
        }
    
        double FE = estimateFuelEfficiency(); // Fuel efficiency
        double emissions = FE * EF; // Emissions in grams/mile
        return emissions;
    }

}
