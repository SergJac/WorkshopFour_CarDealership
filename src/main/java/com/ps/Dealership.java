package com.ps;


import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;
    private String filename;

    public Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Dealership(String filename) {
        this.filename = filename;
        this.inventory = DealershipFileManager.getDealership(filename);
    }

    public static ArrayList<Vehicle> getAllVehiclesByPrice(double minPrice, double maxPrice) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        ArrayList<Vehicle> allVehicles = DealershipFileManager.getDealership("inventory.csv");

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getAllVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        ArrayList<Vehicle> allVehicles = DealershipFileManager.getDealership("inventory.csv");

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getAllVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        ArrayList<Vehicle> allVehicles = DealershipFileManager.getDealership("inventory.csv");

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getAllVehiclesByColor(String color) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        ArrayList<Vehicle> allVehicles = DealershipFileManager.getDealership("inventory.csv");

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getAllVehiclesByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        ArrayList<Vehicle> allVehicles = DealershipFileManager.getDealership("inventory.csv");

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getAllVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        ArrayList<Vehicle> allVehicles = DealershipFileManager.getDealership("inventory.csv");

        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static ArrayList<Vehicle> getAllVehicles() {
       return DealershipFileManager.getDealership("inventory.csv");
    }

    public void addVehicle(Vehicle vehicle){

        inventory.add(vehicle);
        DealershipFileManager.saveDealership(inventory, filename);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public String getFilename() {
        return this.filename;
    }


}
