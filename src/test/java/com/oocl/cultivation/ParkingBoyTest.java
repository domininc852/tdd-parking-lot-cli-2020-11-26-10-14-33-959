package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {

    //given ticket and ticket has been used
    //when fetching car
    //then
    //return null
    @Test
    public void should_return_unrecognized_parking_ticket_error_message_when_fetch_car_given_used_ticket() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new StandardPark());
        Ticket ticket = parkingBoy.parkCar(car);
        Car actual1 = parkingBoy.fetchCar(ticket);
        //when
        final UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkingBoy.fetchCar(ticket);
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
    public void should_return_unrecognized_parking_ticket_error_message_when_fetch_car_given_car_not_existed() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new StandardPark());
        parkingBoy.parkCar(car);
        Ticket ticket2 = new Ticket();
        //when
        final UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            parkingBoy.fetchCar(ticket2);
        });

        //then
        assertEquals("Unrecognized parking ticket", unrecognizedParkingTicketException.getMessage());
    }

    @Test
    public void should_park_according_to_current_park_behavior_when_change_park_behavior_and_park_given_a_parking_boy() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(6);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new StandardPark());
        //when
        parkingBoy.parkCar(car1);
        parkingBoy.setParkBehavior(new SmartPark());
        parkingBoy.parkCar(car2);
        parkingBoy.setParkBehavior(new SuperSmartPark());
        parkingBoy.parkCar(car3);
        //then
        assertEquals(1, parkingLot1.getAvailableSpace());
        assertEquals(9, parkingLot2.getAvailableSpace());
        assertEquals(5, parkingLot3.getAvailableSpace());
    }
}
