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
}
