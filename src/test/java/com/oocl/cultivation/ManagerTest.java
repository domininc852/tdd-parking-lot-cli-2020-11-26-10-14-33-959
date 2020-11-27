package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManagerTest {
    @Test
    public void should_able_to_order_parking_boy_park_when_order_park_given_the_parking_boy_in_the_list() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        parkingLots1.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        ParkingLot parkingLot4 = new ParkingLot(1);
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots2.add(parkingLot3);
        parkingLots2.add(parkingLot4);
        Manager manager = new Manager(parkingLots2);
        manager.addParkingBoyToList(parkingBoy);
        //when
        Ticket ticket = manager.orderPark(parkingBoy, car);
        //then
        assertNotNull(ticket);


    }
}
