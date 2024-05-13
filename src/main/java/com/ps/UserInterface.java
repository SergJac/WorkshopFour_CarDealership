package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private static Dealership dealership;

    private static Scanner scanner = new Scanner(System.in);

    public UserInterface(String filename) {
            dealership = new Dealership("inventory.csv");
    }

    public static void display() {
        init();
    }

    private static void init() {
        int choice;
        do {
            System.out.println("------ Menu ------");
            System.out.println("1. See vehicles by price");
            System.out.println("2. See vehicles by make and model");
            System.out.println("3. See vehicles by year");
            System.out.println("4. See vehicles by color");
            System.out.println("5. See vehicles by mileage");
            System.out.println("6. See vehicles by vehicle type");
            System.out.println("7. See all vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Exit");
            System.out.println("------------------");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();

                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();

                    processGetByPriceRequest(minPrice, maxPrice);
                    break;
                case 2:
                    System.out.println("Enter the make of the vehicle: ");
                    String make = scanner.next();

                    System.out.println("Enter the model of the vehicle: ");
                    String model = scanner.next();

                    processGetByMakeModelRequest(make, model);
                    break;
                case 3:
                    System.out.println("Enter the minimum year: ");
                    int minYear = scanner.nextInt();

                    System.out.println("Enter the maximum year: ");
                    int maxYear = scanner.nextInt();

                    processGetByYearRequest(minYear, maxYear);
                    break;
                case 4:
                    System.out.println("Enter the color of the vehicle: ");
                    String color = scanner.next();

                    processGetByColorRequest(color);
                    break;
                case 5:
                    System.out.println("Enter the minimum mileage: ");
                    int minMileage = scanner.nextInt();

                    System.out.println("Enter the maximum mileage: ");
                    int maxMileage = scanner.nextInt();

                    processGetByMileageRequest(minMileage, maxMileage);
                    break;
                case 6:
                    System.out.println("Enter the type of vehicle: ");
                    String vehicleType = scanner.next();

                    processGetByVehicleTypeRequest(vehicleType);
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

    }

    public static void processGetByPriceRequest(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehiclesWithinPriceRange = Dealership.getAllVehiclesByPrice(minPrice, maxPrice);

        for (Vehicle vehicle : vehiclesWithinPriceRange) {
            System.out.println(vehicle);
        }
    }

    public static void processGetByMakeModelRequest(String make, String model) {
        ArrayList<Vehicle> filteredVehicles = Dealership.getAllVehiclesByMakeModel(make, model);

        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
    }

    private static void processGetByYearRequest(int minYear, int maxYear) {
        ArrayList<Vehicle> vehiclesWithinYearRange = Dealership.getAllVehiclesByYear(minYear, maxYear);

        for (Vehicle vehicle : vehiclesWithinYearRange) {
            System.out.println(vehicle);
        }
    }

    private static void processGetByColorRequest(String color) {
        ArrayList<Vehicle> filteredVehicles = Dealership.getAllVehiclesByColor(color);


        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
    }

    private static void processGetByMileageRequest(int minMileage, int maxMileage) {
        ArrayList<Vehicle> vehiclesWithinYearRange = Dealership.getAllVehiclesByMileage(minMileage, maxMileage);

        for (Vehicle vehicle : vehiclesWithinYearRange) {
            System.out.println(vehicle);
        }
    }

    private static void processGetByVehicleTypeRequest(String vehicleType) {
        ArrayList<Vehicle> filteredVehicles = Dealership.getAllVehiclesByType(vehicleType);

        for (Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
    }

    private static void processAddVehicleRequest() {
        System.out.println("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter make: ");
        String make = scanner.nextLine();

        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter mileage: ");
        int odometer = scanner.nextInt();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        dealership.addVehicle(vehicle);

        System.out.println("Your vehicle has been added to the inventory!");
    }

    private static void processRemoveVehicleRequest() {

        System.out.println("Enter VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {

            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager.saveDealership(dealership.getAllVehicles(), dealership.getFilename());
            System.out.println("Your vehicle has been removed from the inventory!");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found in inventory.");
        }
    }

    public static void displayVehicles(List<Vehicle> vehicles) {
        System.out.println("------ Vehicles ------");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        System.out.println("----------------------");
    }

    public static void processAllVehiclesRequest() {
        displayVehicles(Dealership.getAllVehicles());
    }

    }
