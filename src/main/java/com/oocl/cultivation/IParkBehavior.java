package com.oocl.cultivation;

import java.util.List;

public interface IParkBehavior {
    Ticket park(Car car, List<ParkingLot> parkingLots) throws NotEnoughPositionException;
}
