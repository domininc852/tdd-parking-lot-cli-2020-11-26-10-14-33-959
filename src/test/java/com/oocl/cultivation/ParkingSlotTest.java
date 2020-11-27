package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingSlotTest {
    //given car and parking lot has space
    //when parking car
    //then
    //return ticket
    @Test
    public void should_return_ticket_when_park_car_given_car_parking_slot_with_available_slot() {
        //given
        Car car = new Car();
        ParkingSlot parkingSlot = new ParkingSlot(1);
        //when
        Ticket ticket = parkingSlot.park(car);
        //then
        assertNotNull(ticket);
    }
    //given car and parking lot does not have space
    //when parking car
    //then
    //return null
    @Test
    public void should_return_null_when_park_car_given_car_parking_slot_with_no_available_slot() {
        //given
        Car car = new Car();
        ParkingSlot parkingSlot = new ParkingSlot(0);
        //when
        Ticket ticket = parkingSlot.park(car);
        //then
        assertNull(ticket);
    }

    //given multiple cars and parking lot only have 1 available slot
    //when parking car
    //then
    //return 1 car parked
    @Test
    public void should_return_one_car_parked_when_park_multiple_cars_given_multiple_cars_parking_slot_with_only_1_available_slot() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingSlot parkingSlot = new ParkingSlot(1);
        //when
        Ticket ticket1 = parkingSlot.park(car1);
        Ticket ticket2 = parkingSlot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNull(ticket2);
    }

}
