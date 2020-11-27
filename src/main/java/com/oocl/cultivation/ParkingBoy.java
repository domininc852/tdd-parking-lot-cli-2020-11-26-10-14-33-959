package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingSlot parkingSlot;

    public ParkingBoy(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public void park(Car car) {
        parkingSlot.park(car);
    }
}
