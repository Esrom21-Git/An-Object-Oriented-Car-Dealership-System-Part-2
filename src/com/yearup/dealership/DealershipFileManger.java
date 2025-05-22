package com.yearup.dealership;

import java.io.*;

/**
 * Class responsible for managing dealership data persistence
 */
public class DealershipFileManager {
    private final String dealershipFilePath;

    /**
     * Constructor for DealershipFileManager
     * @param dealershipFilePath path to the dealership data file
     */
    public DealershipFileManager(String dealershipFilePath) {
        this.dealershipFilePath = dealershipFilePath;
    }

    /**
     * Loads dealership data from file
     * @return Dealership object populated with data
     */
    public Dealership loadDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(dealershipFilePath))) {
            // Read dealership information from first line
            String dealershipInfo = reader.readLine();
            if (dealershipInfo != null) {
                String[] details = dealershipInfo.split("\\|");
                if (details.length >= 3) {
                    String name = details[0];
                    String address = details[1];
                    String phone = details[2];

                    dealership = new Dealership(name, address, phone);

                    // Read vehicle inventory
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Vehicle vehicle = parseVehicle(line);
                        if (vehicle != null) {
                            dealership.addVehicle(vehicle);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading dealership data: " + e.getMessage());
            return null;
        }

        return dealership;
    }

    /**
     * Saves dealership data to file
     * @param dealership the dealership to save
     * @return true if successful, false otherwise
     */
    public boolean saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dealershipFilePath))) {
            // Write dealership information
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());

            // Write vehicle inventory
            for (Vehicle vehicle : dealership.getAllVehicles# TurtlePaint Drawing Application

## Project Overview
            This is a Java-based drawing application that demonstrates Object-Oriented Programming (OOP) principles including inheritance, abstraction, and interfaces. The application allows users to draw various shapes on a canvas using a turtle graphics system.

## OOP Principles Demonstrated

### 1. Inheritance
                    - **Shape** (abstract base class) is extended by:
            - Square
                    - Triangle
                    - Circle
                    - Hexagon
                    - All shape classes inherit common properties and methods from Shape

### 2. Abstraction
                    - **Shape** class is abstract with an abstract `paint()` method
                    - Each concrete shape class must implement its own drawing logic
            - Common functionality is abstracted in the base class

### 3. Interfaces
                    - **Drawable** interface defines contract for drawable objects
            - All shape classes implement the Drawable interface
            - Provides consistent drawing behavior across different shapes

### 4. Polymorphism
                    - Shapes can be treated uniformly through the Shape base class
            - Interface implementation allows for consistent method calls
                    - Factory pattern enables flexible shape creation

## Class Structure

```
            Shape (Abstract Class)
├── Square
├── Triangle
├── Circle
└── Hexagon

            Drawable (Interface)
├── Square (implements)
├── Triangle (implements)
├── Circle (implements)
└── Hexagon (implements)

            Supporting Classes:
├── Point (coordinate representation)
├── DrawingCanvas (canvas management)
├── ShapeFactory (shape creation)
└── TurtlePaintApp (main application)
```

## Key Features

### Shape Class (Abstract)
                    - **Properties**: turtle, location (Point), color, border width
                    - **Abstract Method**: `paint()` - must be implemented by subclasses
            - **Common Method**: `prepareToPaint()` - sets up turtle for drawing

### Concrete Shape Classes
                    - **Square**: Draws a square using 4 equal sides and 90° turns
                    - **Triangle**: Draws an equilateral triangle using 3 equal sides and 120° turns
                    - **Circle**: Approximates a circle using many small line segments
            - **Hexagon**: Draws a hexagon using 6 equal sides and 60° turns

### Additional Components
            - **Point Class**: Represents x,y coordinates
                    - **DrawingCanvas**: Manages multiple shapes and canvas operations
            - **ShapeFactory**: Creates shapes using the Factory design pattern
                    - **Drawable Interface**: Ensures consistent drawing behavior

## Usage Example

```java
// Create turtle and canvas
            Turtle turtle = new Turtle();
            DrawingCanvas canvas = new DrawingCanvas(turtle);

// Add shapes to canvas
            canvas.addSquare(new Point(100, 100), Color.RED, 2, 50);
            canvas.addCircle(new Point(200, 100), Color.BLUE, 1, 30);

// Draw all shapes
            canvas.drawAllShapes();
```

## Design Patterns Used

            1. **Template Method Pattern**: Shape class defines the structure, subclasses implement details
            2. **Factory Pattern**: ShapeFactory creates appropriate shape instances
            3. **Strategy Pattern**: Different drawing strategies for each shape type

## How to Run

            1. Ensure you have the TurtlePaint library in your classpath
            2. Compile all Java files
            3. Run `TurtlePaintApp.main()`

## Future Enhancements

            - Add more shape types (Rectangle, Oval, Star, etc.)
                    - Implement shape editing capabilities
                    - Add fill color support
                    - Create a GUI interface
            - Add save/load functionality for drawings()) {
                writer.println(formatVehicleData(vehicle));
            }

            return true;
        } catch (IOException e) {
            System.err.println("Error saving dealership data: " + e.getMessage());
            return false;
        }
    }

    /**
     * Parses a line of vehicle data from the file
     * @param line the line to parse
     * @return Vehicle object, or null if parsing failed
     */
    private Vehicle parseVehicle(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length >= 8) {
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing vehicle data: " + e.getMessage());
        }
        return null;
    }

    /**
     * Formats vehicle data for writing to file
     * @param vehicle the vehicle to format
     * @return formatted string with vehicle data
     */
    private String formatVehicleData(Vehicle vehicle) {
        return vehicle.getVin() + "|" +
                vehicle.getYear() + "|" +
                vehicle.getMake() + "|" +
                vehicle.getModel() + "|" +
                vehicle.getVehicleType() + "|" +
                vehicle.getColor() + "|" +
                vehicle.getOdometer() + "|" +
                vehicle.getPrice();
    }
}
