package com.ParkingLot.vehicles;

import com.ParkingLot.enums.VehicleType;

public abstract  class Vehicle {

    protected VehicleType vehicleType;
    protected String licensePlate;

    public Vehicle(VehicleType type, String licensePlate)
    {
        this.vehicleType = type;
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
