package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    public void should_return_not_enough_position_error_message_when_park_car_given_all_parking_slot_no_available_slot() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Car car1 = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when

        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            parkingBoy.parkCar(car1);
        });
        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
    }

    //given multiple cars and parking lot only have 1 available slot
    //when parking car
    //then
    //return 1 car parked
    @Test
    public void should_return_one_car_parked_and_one_not_enough_position_error_message_when_park_multiple_cars_given_multiple_cars_parking_slot_with_only_1_available_slot() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket1 = parkingBoy.parkCar(car1);
        //when
        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            parkingBoy.parkCar(car2);
        });
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
        //then
        assertNotNull(ticket1);
    }

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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
    void should_park_to_first_parking_lot_when_park_two_car_given_two_parking_lots_with_first_parking_lot_have_available_slot() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);

        //then
        assertEquals(0, parkingLot1.getAvailableSpace());
        assertEquals(1, parkingLot2.getAvailableSpace());
    }

    @Test
    void should_park_to_first_parking_lot_when_park_a_car_given_two_parking_lots_with_first_parking_lot_have_available_slot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket1 = parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        parkingBoy.fetchCar(ticket1);
        parkingBoy.parkCar(car3);
        //then
        assertEquals(0, parkingLot1.getAvailableSpace());
        assertEquals(1, parkingLot2.getAvailableSpace());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_a_car_given_two_parking_lots_with_first_parking_lot_does_not_have_available_slot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        parkingBoy.parkCar(car3);
        //then
        assertEquals(0, parkingLot1.getAvailableSpace());
        assertEquals(0, parkingLot2.getAvailableSpace());
    }

}
