package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    //given car and parking lot has space
    //when parking car
    //then
    //return ticket
    @Test
    public void should_return_ticket_when_park_car_given_car_parking_slot_with_available_slot() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }


    //given multiple cars and parking lot only have available slot
    //when parking car
    //then
    //return all car parked
    @Test
    public void should_return_all_cars_parked_when_park_multiple_cars_given_multiple_cars_parking_slot_with_available_slot(){
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(2);
        //when
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotEquals(ticket1, ticket2);
    }

    //given ticket and ticket has not been used
    //when fetching car
    //then
    //return car
    @Test
    public void should_return_car_when_fetch_car_given_not_used_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        //when
        Car actual = parkingLot.fetchCar(ticket);
        //then
        assertEquals(car, actual);
    }


}
