package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> managementList;

    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        managementList = new ArrayList<>();
    }

    public boolean addParkingBoyToList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
        return false;
    }

    public Ticket orderPark(ParkingBoy parkingBoy, Car car) throws NotEnoughPositionException {
        if (managementList.contains(parkingBoy)) {
            return parkingBoy.parkCar(car);
        }
        return null;
    }
}
