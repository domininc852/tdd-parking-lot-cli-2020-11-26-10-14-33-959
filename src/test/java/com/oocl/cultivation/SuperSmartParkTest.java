package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkTest {
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
        SuperSmartPark superSmartPark = new SuperSmartPark();
        //when
        superSmartPark.park(car4, parkingLots);
        //then
        assertEquals(3, parkingLot1.getAvailableSpace());
        assertEquals(1, parkingLot2.getAvailableSpace());
    }

    @Test
    public void should_park_to_parking_lot_according_to_available_position_rate_when_park_multiple_cars_given_parking_lots_with_different_capacity_and_available_slot() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(6);
        ParkingLot parkingLot2 = new ParkingLot(8);
        ParkingLot parkingLot3 = new ParkingLot(10);
        parkingLot3.park(car1);
        parkingLot3.park(car2);
        parkingLot1.park(car3);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SuperSmartPark superSmartPark = new SuperSmartPark();
        //when
        superSmartPark.park(car4, parkingLots);
        superSmartPark.park(car5, parkingLots);
        superSmartPark.park(car6, parkingLots);
        //then
        assertEquals(4, parkingLot1.getAvailableSpace());
        assertEquals(6, parkingLot2.getAvailableSpace());
        assertEquals(8, parkingLot3.getAvailableSpace());
    }

    @Test
    public void should_return_not_enough_position_error_message_when_park_multiple_cars_given_parking_lots_without_available_slot() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartPark superSmartPark = new SuperSmartPark();
        //when
        superSmartPark.park(car1, parkingLots);
        superSmartPark.park(car2, parkingLots);
        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            superSmartPark.park(car3, parkingLots);
        });
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }
}
