package com.ParkingLot.vehicles;

import com.ParkingLot.enums.VehicleType;

public class Car extends Vehicle {

    public Car( String licensePlate)
    {
        super(VehicleType.CAR, licensePlate);
    }
}
