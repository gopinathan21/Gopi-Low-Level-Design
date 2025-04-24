package com.ParkingLot.vehicles;

import com.ParkingLot.enums.VehicleType;

public class MotorCycle extends Vehicle{
    public MotorCycle(String licensePlate)
    {
        super(VehicleType.MOTORCYCLE,licensePlate);
    }
}
