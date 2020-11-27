package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMoreSpace = this.parkingLots.stream().
                filter(parkingLot -> parkingLot.getAvailableSpace() > 0).
                max(Comparator.comparing(ParkingLot::getAvailableSpace)).
                orElseThrow(NotEnoughPositionException::new);

        return parkingLotWithMoreSpace.park(car);
    }

}
