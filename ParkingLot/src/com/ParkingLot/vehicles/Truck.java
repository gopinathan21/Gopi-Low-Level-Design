package com.ParkingLot.vehicles;

import com.ParkingLot.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String licensePlate)
    {
        super(VehicleType.TRUCK, licensePlate);
    }
}
