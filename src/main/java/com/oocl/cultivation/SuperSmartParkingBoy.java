package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
    @Override
    public Ticket parkCar(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLotWithLargerAvailableRatePosition = this.parkingLots.stream().
                filter(parkingLot -> parkingLot.getAvailableSpace() > 0).
                max(Comparator.comparing(ParkingLot::getAvailablePositionRate)).
                orElseThrow(NotEnoughPositionException::new);

        return parkingLotWithLargerAvailableRatePosition.park(car);
    }
}
