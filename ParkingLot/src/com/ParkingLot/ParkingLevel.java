package com.ParkingLot;

import com.ParkingLot.enums.ParkingSpotType;
import com.ParkingLot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private static int counter = 0;
    private int levelNumber;
    private List<ParkingSpot> spots;

    public ParkingLevel(int carSpotsNo, int truckSpotsNo, int motorSpotsNo) {
        counter++;
        this.levelNumber = counter;
        this.spots = new ArrayList<>();
        for (int i = 0; i < carSpotsNo; i++) {
            spots.add(new ParkingSpot(ParkingSpotType.CAR));
        }
        for (int i = 0; i < truckSpotsNo; i++) {
            spots.add(new ParkingSpot(ParkingSpotType.TRUCK));
        }
        for (int i = 0; i < motorSpotsNo; i++) {
            spots.add(new ParkingSpot(ParkingSpotType.MOTORCYCLE));
        }
    }

    public AvailableSpots availableParkingSpots() {
        AvailableSpots availableSpotsDto = new AvailableSpots();
        int carSpots = 0;
        int bikeSpots = 0;
        int truckSpots = 0;
        List<ParkingSpot> availableSpots = new ArrayList<>();

        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                switch (spot.getSpotType()) {
                    case CAR:
                        carSpots++;
                        break;
                    case MOTORCYCLE:
                        bikeSpots++;
                        break;
                    case TRUCK:
                        truckSpots++;
                        break;
                }
                availableSpots.add(spot);
            }
        }

        availableSpotsDto.carSpots = carSpots;
        availableSpotsDto.bikeSpots = bikeSpots;
        availableSpotsDto.truckSpots = truckSpots;
        availableSpotsDto.parkingSpotList = availableSpots;

        return availableSpotsDto;
    }

    public int parkVehicle(Vehicle vehicle, ParkingSpotType type) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable(type)) {
                spot.setVehicle(vehicle);
                return spot.getSpotNumber();
            }
        }
        return -1;
    }

    public int unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == vehicle) {
                spot.setAvailability(true);
                spot.setVehicle(null);
                return 1;
            }
        }
        return -1;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
