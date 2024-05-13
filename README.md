# Dealership Management System

This Java program implements a simple Dealership Management System. It allows users to interact with a dealership's inventory through a command-line interface (CLI). Users can perform various operations such as viewing vehicles by price, make and model, year, color, mileage, vehicle type, adding a vehicle, and removing a vehicle.

## Features

- **View Vehicles:** Users can view vehicles based on price range, make and model, year, color, mileage, vehicle type, or see all vehicles.
- **Add Vehicle:** Users can add a new vehicle to the inventory.
- **Remove Vehicle:** Users can remove a vehicle from the inventory.

## How to Use

Upon running the program, you will be presented with a menu with various options:

- **See vehicles by price:** Enter minimum and maximum price to view vehicles within that price range.
- **See vehicles by make and model:** Enter the make and model of the vehicle to view vehicles matching that criteria.
- **See vehicles by year:** Enter the minimum and maximum year to view vehicles within that range.
- **See vehicles by color:** Enter the color of the vehicle to view vehicles of that color.
- **See vehicles by mileage:** Enter the minimum and maximum mileage to view vehicles within that range.
- **See vehicles by vehicle type:** Enter the type of vehicle to view vehicles of that type.
- **See all vehicles:** View all vehicles in the inventory.
- **Add a vehicle:** Add a new vehicle to the inventory.
- **Remove a vehicle:** Remove a vehicle from the inventory.
- **Exit:** Exit the program.

## Files

- **Program.java:** Main class containing the `main` method to start the program.
- **Vehicle.java:** Class representing a vehicle with its properties and methods.
- **Dealership.java:** Class representing a dealership with methods to interact with the inventory.
- **UserInterface.java:** Class handling the user interface and interactions.
- **DealershipFileManager.java:** Class for reading from and writing to the inventory file.
- **inventory.csv:** CSV file containing the initial inventory data.

## Requirements

- Java

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.