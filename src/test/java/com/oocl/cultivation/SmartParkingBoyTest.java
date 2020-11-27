package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should_park_to_second_parking_lot_when_park_a_car_given_second_parking_lot_has_more_slots_than_the_first_parking_lot() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(4);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        //when
        parkingBoy.parkCar(car);
        //then
        assertEquals(3,parkingLot1.getAvailableSpace());
        assertEquals(3,parkingLot2.getAvailableSpace());
    }

}
