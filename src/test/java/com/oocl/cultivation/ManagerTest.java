package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerTest {
    @Test
    public void should_return_all_true_when_add_all_kinds_of_parking_boys_given_a_manager_and_three_kinds_of_parking_boys() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        ParkingLot parkingLot4 = new ParkingLot(1);
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        List<ParkingLot> parkingLots3 = new ArrayList<>();
        List<ParkingLot> parkingLots4 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        parkingLots2.add(parkingLot2);
        parkingLots3.add(parkingLot3);
        parkingLots4.add(parkingLot4);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots3);
        Manager manager = new Manager(parkingLots4);
        //when
        boolean isAddParkingBoySuccessful = manager.addParkingBoyToList(parkingBoy);
        boolean isAddSmartParkingBoySuccessful = manager.addParkingBoyToList(smartParkingBoy);
        boolean isAddSuperSmartParkingBoySuccessful = manager.addParkingBoyToList(superSmartParkingBoy);
        //then
        assertTrue(isAddParkingBoySuccessful);
        assertTrue(isAddSmartParkingBoySuccessful);
        assertTrue(isAddSmartParkingBoySuccessful);
    }

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
