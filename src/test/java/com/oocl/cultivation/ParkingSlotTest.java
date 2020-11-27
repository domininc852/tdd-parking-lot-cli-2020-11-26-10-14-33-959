package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingSlotTest {
    //given car and parking lot has space
    //when parking car
    //then
    //return ticket
    @Test
    public void should_return_ticket_when_park_car_given_car_parking_slot_with_available_slot() {
        //given
        Car car = new Car();
        ParkingSlot parkingSlot = new ParkingSlot();
        //when
        Ticket ticket = parkingSlot.park(car);
        //then
        assertNotNull(ticket);
    }
}
