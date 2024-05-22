package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelTruck extends Vehicle implements FossilFuelVehicle{
    int grossVehicleWeightRatingTon; //Gross weight TON
    int engineDisplacementL; //Engine displacement in Liters
    FossilFuelType fossilFuelType; //Fuel type

    final int CO2_GASOLINE_TRUCK_EMISSION_FACTOR = 11100;
    final int CO2_DIESEL_TRUCK_EMISSION_FACTOR = 10250;
    final double NOX_GASOLINE_TRUCK_EMISSION_FACTOR = 2.10;
    final double NOX_DIESEL_TRUCK_EMISSION_FACTOR = 4.60;

    public FossilFuelTruck(String make, String VIN, String model, int year, int weight, int engineDisplacement, FossilFuelType fuelType, int grossVehicleWeightRatingTon) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineDisplacementL = engineDisplacement;
        this.fossilFuelType = fuelType;
        this.grossVehicleWeightRatingTon = grossVehicleWeightRatingTon;
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
    @Override
    public String getVehicleSubType() {
        return "Fossil Fuel";
    }
    @Override
    public String getDescription() {
        return "Type: "+getVehicleType()+", SubType: "+getVehicleSubType()+", Make: "+make+", VIN: "+VIN+", Model: "+model+", Year: "+year+", Weight: "+grossVehicleWeightRatingTon+"T, Engine Displacement: "+engineDisplacementL+"L, Fuel Type: "+fossilFuelType;
    }
    @Override
    public double estimateFuelEfficiency() {
        double constant; // Constant based on fuel type

        switch (this.fossilFuelType) {
            case GASOLINE:
                constant = 10;
                break;
            case DIESEL:
                constant = 14;
                break;
            default:
                throw new IllegalArgumentException("Invalid fuel type");
        }

        double FE = 1000 * (this.engineDisplacementL * constant) / this.grossVehicleWeightRatingTon; // Fuel efficiency in mpg
        return FE;
    }

    @Override
    public double estimateCO2Emissions() {
        double EF; // Emission factor for CO2
    
        switch (this.fossilFuelType) {
            case GASOLINE:
                EF = CO2_GASOLINE_TRUCK_EMISSION_FACTOR;
                break;
            case DIESEL:
                EF = CO2_DIESEL_TRUCK_EMISSION_FACTOR;
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
                EF = NOX_GASOLINE_TRUCK_EMISSION_FACTOR;
                break;
            case DIESEL:
                EF = NOX_DIESEL_TRUCK_EMISSION_FACTOR;
                break;
            default:
                throw new IllegalArgumentException("Invalid fuel type");
        }
    
        double FE = estimateFuelEfficiency(); // Fuel efficiency
        double emissions = FE * EF; // Emissions in grams/mile
        return emissions;
    }

}
