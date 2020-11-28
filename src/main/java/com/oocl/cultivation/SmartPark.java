package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartPark implements IParkBehavior {
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        ParkingLot parkingLotWithMoreSpace = parkingLots.stream().
                filter(parkingLot -> parkingLot.getAvailableSpace() > 0).
                max(Comparator.comparing(ParkingLot::getAvailableSpace)).
                orElseThrow(NotEnoughPositionException::new);

        return parkingLotWithMoreSpace.park(car);
    }
}
