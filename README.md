# Assignment 1: Eco-Conscious Fleet Management System

Imagine you are a start-up creating an eco-conscious fleet management system in Java. You are starting from the ground up, and you want to incorporate sustainability and environmental responsibility into the core design of the entire system. In this assignment, you will develop a subcomponent that manages different types of vehicles and estimates their fuel emissions. 

You'll leverage object-oriented principles by defining a base class for vehicles and creating derived classes for specific vehicle types. Additionally, you'll employ interfaces to define common methods for calculating fuel efficiency and emissions, fostering code reusability and maintainability.

By undertaking this task, you'll lay the foundation for an environmentally-aware fleet management solution that aligns with your company's green-minded vision from the outset.


# Part 1: Interfaces (4 pts)



1. Create an interface called `FossilFuelVehicle` with methods:
    * `double estimateFuelEfficiency();    `
    * `double estimateCO2Emissions();    `
    * `double estimateNOxEmissions();`
2. Create an interface called `ElectricVehicle `with methods:
    * `double estimateFuelEfficiencyEquivalent(); `

All interfaces should be located in the` edu.mdc.cop2805c.assignment1.interfaces` package.


# Part 2: Base Class (5 pts)



1. Create an **abstract **class called `Vehicle` located in the` edu.mdc.cop2805c.assignment1.base` package.
2. Add the following members to the `Vehicle` class:
    * Properties:
        1. **VIN **(String): VIN number of the vehicle
        2. **make **(String)
        3. **model **(String)
        4. **year **(int)
    * An abstract method `getVehicleType()` method should return the type of the vehicle (Car, Truck, or Motorcycle) as a String.
    * An abstract method `getVehicleSubType();` to get the subtype of the vehicle (Electric or Fossil Fuel) as a String.
    * An abstract method `String getDescription();` to get a thorough description of the vehicle.
    * Getters and Setters for all properties.


# Part 3: Derived Classes ( 62 pts)

Create the following classes in the` edu.mdc.cop2805c.assignment1.vehicles` package:



1. (17pts) Create a class called` FossilFuelCar` that extends the `Vehicle` class and  implements the `FossilFuelVehicle` interface. Implement the following:
    * Properties:
        1. **weightKg **(int): weight in Kg
        2. **engineDisplacementL **(double): engine displacement in Liters
        3. **transmissionType **(enum): AUTOMATIC or MANUAL
        4. **fossilFuelType **(enum): GASOLINE or DIESEL
    * Getters and Setters for all properties
    * Constructor signature: `public FossilFuelCar(`

    ```
                String VIN, 
                String make, 
                String model, 
                int year,
                int weightKg, 
                double engineDisplacementL, 
                TransmissionType transmissionType, 
                FossilFuelType fossilFuelType
        )
    ```


    * Note that you should define the **enums **(`TransmissionType`, …) in their own files, such as **<code>TransmissionType.java</code></strong>, so they can be accessed by other classes.
    * The <code>getVehicleType()</code> method should return the type of the vehicle (Car, Truck, or Motorcycle) as a String.
    * The <code>getVehicleSubType()</code> method should return "Fossil Fuel" as a String.
    * The <code>getDescription()</code> method returns a user-friendly description of the vehicle, including its type, make, model, etc as a String
    * The <code>estimateFuelEfficiency()</code> method should estimate the fuel efficiency of the car using the formula.

        <strong>Formula: (Gross approximation)</strong>


        **Where **FE = [(C * D^2.5) / (W^(0.6) * T)] * 1000

    * **FE (mpg):** Estimated fuel efficiency in miles per gallon
    * **D (liters):** Engine displacement in liters
    * **W (kg):** Vehicle weight in kilograms
    * **C (number):** A coefficient based on vehicle category - This factor considers vehicle type and expected aerodynamic drag.** You can use  0.5 for simplicity in this program.**
    * **T (automatic or manual):** Transmission type **(coded as 1 for automatic, 0.8 for manual)**
    * The `estimateCO2Emissions() `and` estimateNOxEmissions()` methods should calculate the emissions of the car using the formula.

        Emissions (grams/mile) = Fuel Efficiency (miles/gallon) * Emission Factor (grams/gallon)


        Where

* **Fuel Efficiency (FE):** fuel efficiency of the vehicle, typically given in miles per gallon (MPG) for gasoline/diesel cars or MPGe (Miles Per Gallon Equivalent) for electric vehicles. 
* **Emission Factor (EF):** This represents the amount of a pollutant emitted per unit of fuel burned. Emission factors vary depending on the pollutant (e.g., CO2, NOx), fuel type (gasoline, diesel), and vehicle type (car, truck). You can find emission factors from government agencies like the EPA or research institutions. **The table in the annexes summarizes the needed factors.**
2. (17pts) Create a class called `FossilFuelTruck` that extends the `Vehicle` class and  implements the `FossiFuelVehicle` interface. Implement the following:
    * Properties:
        5. **grossVehicleWeightRatingTon **(int): Gross weight in Ton
        6. **engineDisplacementL **(double): engine displacement in Liters
        7. **fossilFuelType **(enum): GASOLINE or DIESEL
    * Getters and Setters for all properties
    * Constructor signature: `public FossilFuelTruck(`

    ```
                String VIN, 
                String make, 
                String model, 
                int year,
                int grossVehicleWeightRatingTon, 
                double engineDisplacementL, 
                FossilFuelType fossilFuelType
        )
    ```


    * The `getVehicleType()`  method should return the type of the vehicle (Car, Truck, or Motorcycle) as a String.
    * The `getVehicleSubType()` method should return "Fossil Fuel"as a String.
    * The `getDescription()` method returns a user-friendly description of the vehicle, including its type, make, model, etc as a String
    * The `estimateFuelEfficiency()` method should calculate the fuel efficiency of the truck:

        **Formula**:(Gross formula)


        Estimated Fuel Efficiency (mpg) = 1000 *  (Engine Displacement in liters * Constant) / Gross Vehicle Weight Rating (GVWR) in tons


        Where

* **Constant:** This value can vary depending on engine type, technology, and efficiency. A common estimate for gasoline engines is 10, and for diesel engines,use 14 .
* **GVWR:** This is the maximum weight your truck is designed to carry, found on the vehicle's weight sticker or owner's manual.
    * The `estimateCO2Emissions() `and` estimateNOxEmissions()` methods should calculate the emissions of the truck using the same formula used for FossiFuelCar.
3. (17pts) Create a class called `FossilFuelMotorcycle` that extends the `Vehicle` class  and  implements the `FossilFuelVehicle` interface. Implement the following:
    * Properties:
        8. **weightKg **(int): weight in Kg
        9. **engineDisplacementCC **(double): Engine displacement in cubic centimeters
        10. **frontalAreaSqM **(double):  Frontal area of the motorcycle in square meters
    * Getters and Setters for all properties
    * Constructor signature: ` public FossilFuelMotorcycle(`

    ```
                String VIN, 
                String make, 
                String model, 
                int year,
                int weightKg, 
                double engineDisplacementCC, 
                double frontalAreaSqM 
                )
    ```


    * The `getVehicleType()`  method should return the type of the vehicle (Car, Truck, or Motorcycle) as a String.
    * The `getVehicleSubType()` method should return "Fossil Fuel" as a String.
    * The `getDescription()` method returns a user-friendly description of the vehicle, including its type, make, model, etc as a String
    * The `estimateFuelEfficiency()` method should calculate the fuel efficiency of the motorcycle based on:

         **FE (mpg) = (46.64 - (0.0039 * W) - (0.008 * D)) / (Cd * A)** \



        Where:

    * FE (mpg): Estimated fuel efficiency in miles per gallon
    * W (kg): Vehicle weight in kilograms
    * D (cc): Engine displacement in cubic centimeters
    * Cd: Drag coefficient (specific to motorcycle model, typical values between 0.3 and 0.4). You can use 3.5 in this program.
    * A: Frontal area of the motorcycle (in square meters, can be estimated based on motorcycle dimensions)
    * The `estimateCO2Emissions() `and` estimateNOxEmissions()` methods should calculate the emissions of the truck using the same formula used for FossiFuelCar..
4. (11 pts) Create a class called` ElectricCar` that extends the `Vehicle` class and  implements the `ElectricVehicle` interface. Implement the following:
    * Properties:
        11. **electricityConsumedPerMilekWh **(double)
    * Getters and Setters for all properties
    * Constructor signature: ` public ElectricCar(`

    ```
                String VIN, 
                String make, 
                String model, 
                int year,
                double electricityConsumedPerMilekWh
                )
    ```


    * The `getVehicleType()` method should return the type of the vehicle (Car, Truck, or Motorcycle) as a String.
    * The `getVehicleSubType()` method should return "Electric" as a String.
    * The `getDescription()` method returns a user-friendly description of the vehicle, including its type, make, model, etc as a String
    * The `estimateFuelEfficiencyEquivalent()` method should calculate the fuel efficiency equivalent of the car using:

        MPGe = (Equivalency Factor in kWh/gallon) / (Electricity consumed by car in kWh per mile)


    Where:

* **Electricity consumed by the car per mile (kWh / mile) :** This data can be obtained from the car's trip computer or through monitoring devices.
* **Equivalency factor:** This factor represents the amount of energy in one gallon of gasoline compared to the energy in one kWh of electricity. The US Environmental Protection Agency (EPA) defines this value and updates it periodically. (As of 2023, it's approximately **33.7 kWh/gallon**)


# Part 4: File I/O (10 pts)

Create the following in the` edu.mdc.cop2805c.assignment1.inventory` package:



1. Create a class called `VehicleFileManager` that handles file I/O operations for vehicles.
2. Add the following **static **methods to the `VehicleFileManager` class:
    * `void saveVehiclesToFile(List&lt;Vehicle> vehicles, String filename)` to save a list of vehicles to a file.
    * `List&lt;Vehicle> loadVehiclesFromFile(String filename)` to load a list of vehicles from a file.
3. The file format for saving and loading vehicles should be as follows:
    * Each line in the file represents a vehicle.
    * The first field is the vehicle type (e.g., "Car", "Truck", "Motorcycle"). 
    * The second field is the subtype (“Electric” or “Fossil Fuel”)
    * The subsequent fields are specific to the vehicle type and contain the necessary data for calculating fuel efficiency and emissions
    * Use a **comma **as a delimiter to separate the fields.
    * For enums, use the following encoding:
        1. FossilFuelType: GASOLINE: 1, DIESEL: 2
        2. TransmissionType: AUTOMATIC: 1, MANUAL: 2
4. Use the provided file to test your program (for loading and saving): [vehicles.txt](https://drive.google.com/file/d/1d8xnMEbOeYQSYPCHMIcVtLCIJCbw381q/)


# Part 5: Vehicle List (7 pts)

Create the following in the` edu.mdc.cop2805c.assignment1.inventory` package:



1. Create a class called `VehicleList` that maintains a list of vehicles.
2. Add the following methods to the `VehicleList` class:
    * `void addVehicle(Vehicle vehicle)` to add a vehicle to the list.
    * `void removeVehicle(Vehicle vehicle)` to remove a vehicle from the list.
    * `List&lt;Vehicle> getAllVehicles()` to get a list of all vehicles.
    * `List&lt;Vehicle> getVehiclesByType(String type)` to get a list of vehicles of a specific type (e.g., "Car", "Truck", "Motorcycle").
    * Two  Constructors that can create 1) an empty list, or 2)  load vehicles from a CSV file, given the filename
    * `void saveToFile(String filename)` to save vehicles to a file


# Part 6: Main class and User Interface (12 pts)

Create a class called `VehicleManager` that will serve as the **entry point** of the application and provide a **user interface (UI) **for interacting with the vehicle management system. It should be located in the `edu.mdc.cop2805c.assignment1.app ` package.



1. In the `VehicleManager` class, implement a `main` method that displays a** menu-driven** **UI t**o the user.
2. Before the menu is displayed, vehicles should be loaded from a file named “vehicles.txt”
3. The menu should present the following options:
    * View all vehicles in the system (User enters ‘1’ and is shown a complete description of the vehicles in the system)
    * View vehicles by type (Car, Truck, Motorcycle)  (User enters ‘2’)
    * Add a new vehicle (User enters ‘3’, then the type of Vehicle (Car, Truck, ..), then the subtype (Electric , or Fossil Fuel), then all the properties in the order of the class constructor )
    * Remove an existing vehicle (User enters ‘4’,  is presented with the list of vehicles, then enters the index of the vehicle to remove)
    * Display fuel efficiency and/or emissions for a vehicle (User enters ‘5’)
    * Display fuel efficiency and/or emissions for a vehicle type (User enters ‘6’ , then the type of Vehicle (Car, Truck, ..))
    * Display fuel efficiency and/or emissions for all vehicles (User enters ‘7’)
    * Exit the program (User enters Q)
4. Implement methods to handle each menu option, utilizing the classes you have created (`Vehicle`, `VehicleList`, `VehicleFileManager, etc`).
5. For the "Add a new vehicle" option, prompt the user to enter the necessary details and create an instance of the corresponding vehicle class. Add the new vehicle to the `VehicleList`.
6. For the "Remove an existing vehicle" option, display a list of all vehicles currently in the `VehicleList` and prompt the user to select a vehicle to remove.
7. For the "Calculate fuel efficiency" and "Calculate emissions" options, display a list of all vehicles currently in the `VehicleList` and prompt the user to select a vehicle. Then, calculate and display the fuel efficiency or emissions for the selected vehicle using the corresponding methods from the vehicle class.
8. For the "View all vehicles" option, display a list of all vehicles currently in the `VehicleList`, along with their types, fuel efficiency, and emissions.
9. For the "View vehicles by type" option, prompt the user to enter a vehicle type (e.g., "Car", "Truck", "Motorcycle") and display a list of vehicles of that type, along with their fuel efficiency and emissions.
10. The `main` method should continuously display the menu options to the user until the "Exit" option is selected (User enters ‘Q’).** Before exiting **vehicles are saved into the file “vehicles.txt” 


# Submission

Submit your solution as a **ZIP **file containing a **“vehicles.txt”** file and  **all the source code files** (`.java` files) for the classes you implemented, organized into the following packages.



* `edu.mdc.cop2805c.assignment1.interfaces` (for `ElectricVehicle` and `FossilFuelVehicle` interfaces) 
* `edu.mdc.cop2805c.assignment1.base` (for the `Vehicle` and the enums classes (TransmissionType, FossiFuelType, etc))
* `edu.mdc.cop2805c.assignment1.vehicles` (for the derived classes `FossilFuelCar`, `FossilFuelTruck`, `ElectricCar`, and `FossilFuelMotorcycle`) 
* `edu.mdc.cop2805c.assignment1.inventory` (for the `VehicleList`and `VehicleFileManager` classes) 
* `edu.mdc.cop2805c.assignment1.ap`p (for the `VehicleManager` main class)

Other requirements:



* Make sure that your decompressed files contain the following folders **at the root**: 
    * edu, 
    * edu\mdc, 
    * edu\mdc\cop2805c
    * etc..
* Please make your classes **public **because they will be tested automatically.
* Please name your file “**LastName, FirstName.zip”** and submit through Canvas. Make sure to spell your first and last names as they appear on Canvas.
* If you want a **detailed report** of the grading emailed to you, please include a text file called “email.txt” with your MDC email address in the root of the zip file.


# 


# Annexes


## Emission Calculations


    Emissions (grams/mile) = Fuel Efficiency (miles/gallon) * Emission Factor (grams/gallon)

Where



* **Fuel Efficiency (FE):** Obtain the fuel efficiency of the vehicle, typically given in miles per gallon (MPG) for gasoline/diesel cars or MPGe (Miles Per Gallon Equivalent) for electric vehicles. This data can be found from the car's manual, manufacturer website, or official sources like the EPA website.
* **Emission Factor (EF):** This represents the amount of a pollutant emitted per unit of fuel burned. Emission factors vary depending on the pollutant (e.g., CO2, NOx), fuel type (gasoline, diesel), and vehicle type (car, truck). You can find emission factors from government agencies like the EPA or research institutions.

Use the table below showing some typical emission factors for different vehicle types and pollutants:


<table>
  <tr>
   <td><strong>Vehicle Type</strong>
   </td>
   <td><strong>Pollutant</strong>
   </td>
   <td><strong>Emission Factor (grams/mile)</strong>
   </td>
   <td><strong>Source</strong>
   </td>
  </tr>
  <tr>
   <td>Gasoline Car
   </td>
   <td>CO2
   </td>
   <td>8887
   </td>
   <td><a href="https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator">https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator</a>
   </td>
  </tr>
  <tr>
   <td>Gasoline Car
   </td>
   <td>NOx
   </td>
   <td>0.68
   </td>
   <td><a href="https://www.epa.gov/moves/mobile-source-emission-factors-research">https://www.epa.gov/moves/mobile-source-emission-factors-research</a>
   </td>
  </tr>
  <tr>
   <td>Gasoline Truck
   </td>
   <td>CO2
   </td>
   <td>11,100
   </td>
   <td><a href="https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator">https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator</a>
   </td>
  </tr>
  <tr>
   <td>Gasoline Truck
   </td>
   <td>NOx
   </td>
   <td>2.10
   </td>
   <td><a href="https://www.epa.gov/moves/mobile-source-emission-factors-research">https://www.epa.gov/moves/mobile-source-emission-factors-research</a>
   </td>
  </tr>
  <tr>
   <td>Diesel Car
   </td>
   <td>CO2
   </td>
   <td>8260
   </td>
   <td><a href="https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator">https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator</a>
   </td>
  </tr>
  <tr>
   <td>Diesel Car
   </td>
   <td>NOx
   </td>
   <td>2.01
   </td>
   <td><a href="https://www.epa.gov/moves/mobile-source-emission-factors-research">https://www.epa.gov/moves/mobile-source-emission-factors-research</a>
   </td>
  </tr>
  <tr>
   <td>Diesel Truck
   </td>
   <td>CO2
   </td>
   <td>10,250
   </td>
   <td><a href="https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator">https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator</a>
   </td>
  </tr>
  <tr>
   <td>Diesel Truck
   </td>
   <td>NOx
   </td>
   <td>4.60
   </td>
   <td><a href="https://www.epa.gov/moves/mobile-source-emission-factors-research">https://www.epa.gov/moves/mobile-source-emission-factors-research</a>
   </td>
  </tr>
  <tr>
   <td>Motorcycle
   </td>
   <td>CO2
   </td>
   <td>4,600
   </td>
   <td><a href="https://ww2.arb.ca.gov/our-work/programs/on-road-motorcycles">https://ww2.arb.ca.gov/our-work/programs/on-road-motorcycles</a>
   </td>
  </tr>
  <tr>
   <td>Motorcycle
   </td>
   <td>NOx
   </td>
   <td>3.20
   </td>
   <td><a href="https://ww2.arb.ca.gov/our-work/programs/on-road-motorcycles">https://ww2.arb.ca.gov/our-work/programs/on-road-motorcycles</a>
   </td>
  </tr>
</table>

