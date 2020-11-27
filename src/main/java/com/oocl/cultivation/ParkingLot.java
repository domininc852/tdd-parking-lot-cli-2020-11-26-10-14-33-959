package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Car> cars;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        cars=new ArrayList<>();
    }

    public Ticket park(Car car) {
        if(capacity-cars.size()<=0){
            return null;
        }
        cars.add(car);
        return new Ticket();
    }
}
