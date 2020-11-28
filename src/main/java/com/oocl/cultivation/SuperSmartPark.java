package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartPark implements IParkBehavior {
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        ParkingLot parkingLotWithLargerAvailableRatePosition = parkingLots.stream().
                filter(parkingLot -> parkingLot.getAvailableSpace() > 0).
                max(Comparator.comparing(ParkingLot::getAvailablePositionRate)).
                orElseThrow(NotEnoughPositionException::new);

        return parkingLotWithLargerAvailableRatePosition.park(car);
    }
}
