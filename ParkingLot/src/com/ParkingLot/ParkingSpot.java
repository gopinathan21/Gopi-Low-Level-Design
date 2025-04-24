package com.ParkingLot;

import com.ParkingLot.enums.ParkingSpotType;
import com.ParkingLot.enums.VehicleType;
import com.ParkingLot.vehicles.Vehicle;

public class ParkingSpot {

    private  static int counter = 0;
    private int spotNumber;
    private ParkingSpotType spotType;
    private Vehicle vehicle = null;
    private boolean isAvailable;

    public ParkingSpot( ParkingSpotType spotType )
    {
        counter++;
        this.spotNumber = counter;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public boolean isAvailable(ParkingSpotType type)
    {
        return this.isAvailable && this.spotType == type;
    }

    public boolean isAvailable()
    {
        return this.isAvailable;
    }


    public int getSpotNumber()
    {
        return this.spotNumber;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setAvailability(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    public void setVehicle(Vehicle vechicle) {
        this.vehicle = vechicle;
    }

    public ParkingSpotType getParkingSpotType()
    {
        return this.spotType;
    }

}
