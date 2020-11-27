package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketCarMap = new HashMap<>();
    }

    public Ticket park(Car car) throws NotEnoughPosition {
        if (capacity - ticketCarMap.size() <= 0) {
            throw new NotEnoughPosition();
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicket {
        Car car = ticketCarMap.get(ticket);
        if (car == null) {
            throw new UnrecognizedParkingTicket();
        }
        ticketCarMap.remove(ticket);
        return car;
    }
}
