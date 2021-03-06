package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots;
    protected IParkBehavior parkBehavior;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkBehavior = new StandardPark();
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException {
        return parkBehavior.park(car, this.parkingLots);
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
        Optional<ParkingLot> parkingLotOptional = Optional.ofNullable(parkingLots.stream().
                filter(parkingLot -> parkingLot.isCarExist(ticket)).
                findFirst().
                orElseThrow(UnrecognizedParkingTicketException::new));
        return parkingLotOptional.get().fetchCar(ticket);

    }

    public void setParkBehavior(IParkBehavior parkBehavior) {
        this.parkBehavior = parkBehavior;
    }
}
