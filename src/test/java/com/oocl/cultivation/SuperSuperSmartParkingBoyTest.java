package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSuperSmartParkingBoyTest {
    @Test
    public void should_park_to_second_parking_lot_when_park_a_car_given_second_parking_lot_has_larger_available_position_rate_but_fewer_available_slot_than_first_parking_lot() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(3);
        parkingLot1.park(car1);
        parkingLot1.park(car2);
        parkingLot2.park(car3);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);
        //when
        parkingBoy.parkCar(car4);
        //then
        assertEquals(3, parkingLot1.getAvailableSpace());
        assertEquals(1, parkingLot2.getAvailableSpace());
    }
}
