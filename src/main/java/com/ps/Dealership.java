package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public List<Vehicle> getAllVehiclesByPrice(double minPrice, double maxPrice) {
        return null;
    }

    public List<Vehicle> getAllVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public List<Vehicle> getAllVehiclesByYear(int minYear, int maxYear) {
        return null;
    }

    public List<Vehicle> getAllVehiclesByColor(String Color) {
        return null;
    }

    public List<Vehicle> getAllVehiclesByMileage(int minMileage, int maxMileage) {
        return null;
    }

    public List<Vehicle> getAllVehiclesByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {}


}
