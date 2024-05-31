package edu.mdc.cop2805c.assignment1.base;

public abstract class Vehicle {
    protected String VIN;
    protected String make;
    protected String model;
    protected int year;

    //Getters and Setters
    public String getVIN() {
        return VIN;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }

    //Made these public so that they can be accessed anywhere in the App
    public abstract String getVehicleType();
    public abstract String getVehicleSubType();
    public abstract String getDescription();
    public String toFileFormat(){// use getters and setters
        return getVehicleType()+","+getVehicleSubType()+","+getVIN()+","+getMake()+","+getModel()+","+getYear();
    };
}
