package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int CAPACITY;
    private Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.CAPACITY = capacity;
        ticketCarMap = new HashMap<>();
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        Car car = ticketCarMap.get(ticket);
        ticketCarMap.remove(ticket);
        return car;
    }

    public int getAvailableSpace() {
        return CAPACITY - ticketCarMap.size();
    }

    public boolean isCarExist(Ticket ticket) {
        return ticketCarMap.get(ticket)!=null;
    }
    public double getAvailablePositionRate(){
        return (getAvailableSpace())*1.0/ CAPACITY;
    }


}
