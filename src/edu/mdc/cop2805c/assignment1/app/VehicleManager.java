package edu.mdc.cop2805c.assignment1.app;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelType;
import edu.mdc.cop2805c.assignment1.vehicles.TransmissionType;

public class VehicleManager {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        FossilFuelCar car = new FossilFuelCar("6969","1969", "chebyu", 1969, 1500, 4.5, TransmissionType.AUTOMATIC, FossilFuelType.GASOLINE);
        System.out.println(car.getDescription());
    }
}
