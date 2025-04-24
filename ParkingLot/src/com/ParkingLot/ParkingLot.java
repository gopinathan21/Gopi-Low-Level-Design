package com.ParkingLot;

import com.ParkingLot.enums.ParkingSpotType;
import com.ParkingLot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingLevel> levels = new ArrayList<>();

    public void addLevel(int carSpotsNo, int truckSpotsNo, int motorSpotsNo) {
        levels.add(new ParkingLevel(carSpotsNo, truckSpotsNo, motorSpotsNo));
    }

    public void displayAvailability() {
        System.out.println("LevelNumber   CarSpotAvailable, TruckSpotAvailable, MotorCycleSpotAvailable");
        for (ParkingLevel level : levels) {
            AvailableSpots availableSpotsDTO = level.availableParkingSpots();
            System.out.println(level.getLevelNumber() + "      " +
                    availableSpotsDTO.carSpots + "                     " +
                    availableSpotsDTO.truckSpots + "                      " +
                    availableSpotsDTO.bikeSpots);
        }
    }

    public int parkVehicle(int levelNumber, Vehicle vehicle, ParkingSpotType type) {
        for (ParkingLevel level : levels) {
            if (level.getLevelNumber() == levelNumber) {
                return level.parkVehicle(vehicle, type);
            }
        }
        return -1;
    }

    public int unparkVehicle(int levelNumber, Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.getLevelNumber() == levelNumber) {
                return level.unparkVehicle(vehicle);
            }
        }
        return -1;
    }
}
