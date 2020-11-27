package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        Optional<ParkingLot> parkingLotOptional=parkingLots.stream().filter(parkingLot -> parkingLot.getAvailableSpace()>0).findFirst();
        if (parkingLotOptional.isPresent()){
            return parkingLotOptional.get().park(car);
        }
        return parkingLots.get(0).park(car);


    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return parkingLots.get(0).fetchCar(ticket);
    }
}
