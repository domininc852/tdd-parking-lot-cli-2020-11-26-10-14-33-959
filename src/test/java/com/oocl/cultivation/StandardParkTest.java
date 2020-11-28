package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class StandardParkTest {
    @Test
    public void should_return_not_enough_position_error_message_when_park_car_given_all_parking_slot_no_available_slot() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        Car car1 = new Car();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardPark standardPark = new StandardPark();
        //when

        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            standardPark.park(car1, parkingLots);
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
        StandardPark standardPark = new StandardPark();
        Ticket ticket1 = standardPark.park(car1, parkingLots);
        //when
        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            standardPark.park(car2, parkingLots);
        });
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
        //then
        assertNotNull(ticket1);
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
        StandardPark standardPark = new StandardPark();
        //when
        standardPark.park(car1, parkingLots);
        standardPark.park(car2, parkingLots);

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
        StandardPark standardPark = new StandardPark();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket1 = standardPark.park(car1, parkingLots);
        standardPark.park(car2, parkingLots);
        parkingBoy.fetchCar(ticket1);
        standardPark.park(car3, parkingLots);
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
        StandardPark standardPark = new StandardPark();
        //when
        standardPark.park(car1, parkingLots);
        standardPark.park(car2, parkingLots);
        standardPark.park(car3, parkingLots);
        //then
        assertEquals(0, parkingLot1.getAvailableSpace());
        assertEquals(0, parkingLot2.getAvailableSpace());
    }
}
