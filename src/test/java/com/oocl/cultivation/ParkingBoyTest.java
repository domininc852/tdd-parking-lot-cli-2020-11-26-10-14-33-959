package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    void should_be_parked_once_when_park_a_car_given_car_parking_boy_parking_slot() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        //when
        parkingBoy.park(car);
        //then
        Mockito.verify(parkingLot, times(1)).park(car);
    }

    @Test
    void should_be_fetched_when_fetch_a_car_given_ticket_parking_boy_parking_slot() throws UnrecognizedParkingTicketException {
        //given
        Car car = new Car();
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        //when
        parkingBoy.fetch(ticket);

        //then
        Mockito.verify(parkingLot, times(1)).fetchCar(ticket);
    }
    @Test
    void should_park_to_first_parking_lot_when_park_two_car_given_two_parking_lots_with_first_parking_lot_have_available_slot() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots=new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        //then
        assertEquals(0,parkingLot1.getAvailableSpace());
        assertEquals(1,parkingLot2.getAvailableSpace());
    }
    @Test
    void should_park_to_first_parking_lot_when_park_a_car_given_two_parking_lots_with_first_parking_lot_have_available_slot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots=new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket1=parkingBoy.park(car1);
        parkingBoy.park(car2);
        parkingBoy.fetch(ticket1);
        parkingBoy.park(car3);
        //then
        assertEquals(0,parkingLot1.getAvailableSpace());
        assertEquals(1,parkingLot2.getAvailableSpace());
    }
    @Test
    void should_park_to_second_parking_lot_when_park_a_car_given_two_parking_lots_with_first_parking_lot_does_not_have_available_slot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots=new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.park(car1);
        parkingBoy.park(car2);
        parkingBoy.park(car3);
        //then
        assertEquals(0,parkingLot1.getAvailableSpace());
        assertEquals(0,parkingLot2.getAvailableSpace());
    }

}
