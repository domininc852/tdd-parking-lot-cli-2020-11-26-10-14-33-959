package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) throws NotEnoughPositionException {
        Optional<ParkingLot> parkingLotOptional = parkingLots.stream().filter(parkingLot -> parkingLot.getAvailableSpace() > 0).findFirst();
        if (parkingLotOptional.isPresent()) {
            return parkingLotOptional.get().park(car);
        }
        throw new NotEnoughPositionException();


    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
        Optional<ParkingLot> parkingLotOptional = parkingLots.stream().filter(parkingLot -> parkingLot.isCarExist(ticket)).findFirst();
        if (parkingLotOptional.isPresent()) {
            return parkingLotOptional.get().fetchCar(ticket);
        }
        throw new UnrecognizedParkingTicketException();
    }
}
