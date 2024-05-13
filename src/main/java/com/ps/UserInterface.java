package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
        init();
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            init();

            System.out.println("------ Menu ------");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by vehicle type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Exit");
            System.out.println("------------------");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
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

    private void processGetByPriceRequest() {

    }

    private void processGetByMakeModelRequest() {

    }

    private void processGetByYearRequest() {

    }

    private void processGetByColorRequest() {

    }

    private void processGetByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("------ Vehicles ------");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        System.out.println("----------------------");
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

}
