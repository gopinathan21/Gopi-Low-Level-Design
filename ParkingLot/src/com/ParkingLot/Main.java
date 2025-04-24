package com.ParkingLot;

import com.ParkingLot.enums.VehicleType;
import com.ParkingLot.vehicles.Car;
import com.ParkingLot.vehicles.MotorCycle;
import com.ParkingLot.vehicles.Vehicle;
import com.ParkingLot.enums.ParkingSpotType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addLevel(10, 10, 10);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Display Parking Lot Availability");
            System.out.println("2. Park a Vehicle");
            System.out.println("3. Unpark a Vehicle");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkingLot.displayAvailability();
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline left by nextInt()
                    System.out.print("Enter vehicle type (CAR, MOTORCYCLE, TRUCK): ");
                    String vehicleTypeStr = scanner.nextLine().toUpperCase();
                    System.out.print("Enter license plate: ");
                    String licensePlate = scanner.nextLine();

                    VehicleType vehicleType = VehicleType.valueOf(vehicleTypeStr);
                    Vehicle vehicle;
                    switch (vehicleType) {
                        case CAR:
                            vehicle = new Car(licensePlate);
                            break;
                        case MOTORCYCLE:
                            vehicle = new MotorCycle(licensePlate);
                            break;
                        default:
                            System.out.println("Invalid vehicle type!");
                            continue;
                    }

                    System.out.print("Enter level number to park: ");
                    int levelNumber = scanner.nextInt();
                    int spotNumber = parkingLot.parkVehicle(levelNumber, vehicle, ParkingSpotType.valueOf(vehicleTypeStr));
                    if (spotNumber != -1) {
                        System.out.println("Vehicle parked successfully in spot number: " + spotNumber);
                    } else {
                        System.out.println("Parking failed. No available spots.");
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline left by nextInt()
                    System.out.print("Enter vehicle type (CAR, MOTORCYCLE, TRUCK): ");
                    vehicleTypeStr = scanner.nextLine().toUpperCase();
                    System.out.print("Enter license plate: ");
                    licensePlate = scanner.nextLine();

                    vehicleType = VehicleType.valueOf(vehicleTypeStr);
                    vehicle = switch (vehicleType) {
                        case CAR -> new Car(licensePlate);
                        case MOTORCYCLE -> new MotorCycle(licensePlate);
                        default -> null;
                    };

                    System.out.print("Enter level number to unpark: ");
                    levelNumber = scanner.nextInt();
                    int result = parkingLot.unparkVehicle(levelNumber, vehicle);
                    if (result != -1) {
                        System.out.println("Vehicle with license plate " + licensePlate + " unparked successfully.");
                    } else {
                        System.out.println("Unparking failed. Vehicle not found in specified level.");
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }

        scanner.close();
    }
}
