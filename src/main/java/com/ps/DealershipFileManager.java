package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {
        Dealership dealership = new Dealership();
        String line;
        String delimiter = "\\|";

        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dealership;

    }

    public void saveDealership() {

    }

}
