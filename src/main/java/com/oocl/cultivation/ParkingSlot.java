package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.List;

public class ParkingSlot {
    private final int capacity;
    private List<Car> cars;
    public ParkingSlot(int capacity) {
        this.capacity = capacity;
        cars=new ArrayList<>();
    }

    public Ticket park(Car car) {
        return new Ticket();
    }
}
