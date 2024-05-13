package com.ps;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {


    public static ArrayList<Vehicle> getDealership(String filename) {
        ArrayList<Vehicle> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");

                    if (parts.length == 8) {

                        int vin = Integer.parseInt(parts[0]);
                        int year = Integer.parseInt(parts[1]);
                        String make = parts[2];
                        String model = parts[3];
                        String vehicleType = parts[4];
                        String color = parts[5];
                        int odometer = Integer.parseInt(parts[6]);
                        double price = Double.parseDouble(parts[7]);

                        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                        inventory.add(vehicle);

                    } else {

                        System.out.println("Invalid format in line: " + line);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventory;
    }

    public static void saveDealership(ArrayList<Vehicle> inventory, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (Vehicle vehicle : inventory) {
                    writer.write(vehicleToString(vehicle));
                    writer.newLine();
            }

            } catch(IOException e){
                System.err.println("Error saving inventory: " + e.getMessage());
            }
        }

        private static String vehicleToString (Vehicle vehicle){
            return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }

    }
