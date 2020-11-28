package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class StandardPark implements IParkBehavior {
    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException {
        Optional<ParkingLot> parkingLotOptional = Optional.ofNullable(parkingLots.stream().
                filter(parkingLot -> parkingLot.getAvailableSpace() > 0).
                findFirst().
                orElseThrow(NotEnoughPositionException::new));
        return parkingLotOptional.get().park(car);
    }
}
