package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    //given car and parking lot has space
    //when parking car
    //then
    //return ticket
    @Test
    public void should_return_ticket_when_park_car_given_car_parking_slot_with_available_slot() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_not_enough_position_error_message_when_park_car_given_parking_slot_no_available_slot() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        //when
        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            parkingLot.park(car);
        });
        assertEquals("Not enough Position", notEnoughPositionException.getMessage());
        //then
    }

    //given multiple cars and parking lot only have 1 available slot
    //when parking car
    //then
    //return 1 car parked
    @Test
    public void should_return_one_car_parked_and_one_not_enough_position_error_message_when_park_multiple_cars_given_multiple_cars_parking_slot_with_only_1_available_slot() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket1 = parkingLot.park(car1);
        //when
        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            parkingLot.park(car2);
        });
        assertEquals("Not enough Position", notEnoughPositionException.getMessage());
        //then
        assertNotNull(ticket1);
    }

    //given multiple cars and parking lot only have available slot
    //when parking car
    //then
    //return all car parked
    @Test
    public void should_return_all_cars_parked_when_park_multiple_cars_given_multiple_cars_parking_slot_with_available_slot() throws NotEnoughPositionException {
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
    public void should_return_car_when_fetch_car_given_not_used_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        //when
        Car actual = parkingLot.fetchCar(ticket);
        //then
        assertEquals(car, actual);
    }

    //given ticket and ticket has been used
    //when fetching car
    //then
    //return null
    @Test
    public void should_return_unrecognized_parking_ticket_error_message_when_fetch_car_given_used_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        Car actual1 = parkingLot.fetchCar(ticket);
        //when
        final UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkingLot.fetchCar(ticket);
        });
        //then
        assertNotNull(actual1);
        assertEquals(car, actual1);
        assertEquals("Unrecognized parking ticket", unrecognizedParkingTicketException.getMessage());
    }

    //given ticket and car does not exist
    //when fetching car
    //then
    //return null
    @Test
    public void should_return_null_when_fetch_car_given_car_not_existed() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        Ticket ticket2 = new Ticket();
        //when
        final UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkingLot.fetchCar(ticket2);
        });

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedParkingTicketException.getMessage());
    }

}
