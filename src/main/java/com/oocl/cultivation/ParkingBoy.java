package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots;
    private IParkBehavior parkBehavior;

    public ParkingBoy(List<ParkingLot> parkingLots, IParkBehavior parkBehavior) {
        this.parkingLots = parkingLots;
        this.parkBehavior = parkBehavior;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException {
//        Optional<ParkingLot> parkingLotOptional = Optional.ofNullable(parkingLots.stream().
//                filter(parkingLot -> parkingLot.getAvailableSpace() > 0).
//                findFirst().
//                orElseThrow(NotEnoughPositionException::new));
//        return parkingLotOptional.get().park(car);
        return parkBehavior.park(car, this.parkingLots);
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
        Optional<ParkingLot> parkingLotOptional = Optional.ofNullable(parkingLots.stream().
                filter(parkingLot -> parkingLot.isCarExist(ticket)).
                findFirst().
                orElseThrow(UnrecognizedParkingTicketException::new));
        return parkingLotOptional.get().fetchCar(ticket);

    }
}
