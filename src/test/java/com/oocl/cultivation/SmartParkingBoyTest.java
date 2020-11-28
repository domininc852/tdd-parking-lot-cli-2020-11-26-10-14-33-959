package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(3, parkingLot1.getAvailableSpace());
        assertEquals(3, parkingLot2.getAvailableSpace());
    }

    @Test
    public void should_park_evenly_to_the_parking_lots_when_park_multiple_cars_given_all_parking_lots_has_same_number_of_available_slots() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ParkingLot parkingLot3 = new ParkingLot(3);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        //when
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        parkingBoy.parkCar(car3);
        //then
        assertEquals(2, parkingLot1.getAvailableSpace());
        assertEquals(2, parkingLot2.getAvailableSpace());
        assertEquals(2, parkingLot3.getAvailableSpace());
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);
        //when
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            parkingBoy.parkCar(car3);
        });
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }
}
