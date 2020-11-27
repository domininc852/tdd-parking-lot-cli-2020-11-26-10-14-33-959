package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketCarMap = new HashMap<>();
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        if (capacity - ticketCarMap.size() <= 0) {
            throw new NotEnoughPositionException();
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car = ticketCarMap.get(ticket);
        if (car == null) {
            throw new UnrecognizedParkingTicketException();
        }
        ticketCarMap.remove(ticket);
        return car;
    }

    public int getAvailableSpace() {
        return capacity - ticketCarMap.size();
    }


}
