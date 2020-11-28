package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(isAddSuperSmartParkingBoySuccessful);
    }

    @Test
    public void should_return_false_when_add_other_manager_given_two_manager() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        parkingLots2.add(parkingLot2);
        Manager manager1 = new Manager(parkingLots1);
        Manager manager2 = new Manager(parkingLots2);
        //when
        boolean isManagerSuccessful = manager1.addParkingBoyToList(manager2);
        //then
        assertFalse(isManagerSuccessful);
    }

    @Test
    public void should_able_to_order_all_kinds_of_parking_boys_park_when_order_park_given_the_parking_boys_in_the_list() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
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
        manager.addParkingBoyToList(parkingBoy);
        manager.addParkingBoyToList(smartParkingBoy);
        manager.addParkingBoyToList(superSmartParkingBoy);
        //when
        Ticket ticket1 = manager.orderPark(parkingBoy, car1);
        Ticket ticket2 = manager.orderPark(smartParkingBoy, car2);
        Ticket ticket3 = manager.orderPark(superSmartParkingBoy, car3);
        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
    }

    @Test
    public void should_not_able_to_order_any_kinds_of_parking_boys_park_when_order_park_given_the_parking_boys_not_in_the_list() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
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
        Ticket ticket1 = manager.orderPark(parkingBoy, car1);
        Ticket ticket2 = manager.orderPark(smartParkingBoy, car2);
        Ticket ticket3 = manager.orderPark(superSmartParkingBoy, car3);
        //then
        assertNull(ticket1);
        assertNull(ticket2);
        assertNull(ticket3);
    }

    @Test
    public void should_return_not_enough_position_error_message_when_order_park_given_the_parking_lots_managed_by_the_parking_boy_does_not_have_enough_space() throws NotEnoughPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        parkingLots1.add(parkingLot2);
        parkingLots2.add(parkingLot3);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots1);
        Manager manager = new Manager(parkingLots2);
        manager.addParkingBoyToList(smartParkingBoy);
        //when
        Ticket ticket1 = manager.orderPark(smartParkingBoy, car1);
        Ticket ticket2 = manager.orderPark(smartParkingBoy, car2);

        final NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> {
            manager.orderPark(smartParkingBoy, car3);
        });
        //then
        assertEquals("Not enough position", notEnoughPositionException.getMessage());
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    @Test
    public void should_able_to_order_all_kinds_of_parking_boys_fetch_car_when_order_fetch_given_the_parking_boys_in_the_list() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
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
        manager.addParkingBoyToList(parkingBoy);
        manager.addParkingBoyToList(smartParkingBoy);
        manager.addParkingBoyToList(superSmartParkingBoy);
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = smartParkingBoy.parkCar(car2);
        Ticket ticket3 = superSmartParkingBoy.parkCar(car3);
        //when
        Car actualCar1 = manager.orderFetch(parkingBoy, ticket1);
        Car actualCar2 = manager.orderFetch(smartParkingBoy, ticket2);
        Car actualCar3 = manager.orderFetch(superSmartParkingBoy, ticket3);

        //then
        assertEquals(car1, actualCar1);
        assertEquals(car2, actualCar2);
        assertEquals(car3, actualCar3);
    }

    @Test
    public void should_not_able_to_order_any_kinds_of_parking_boys_fetch_car_when_order_fetch_given_the_parking_boys_not_in_the_list() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
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
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = smartParkingBoy.parkCar(car2);
        Ticket ticket3 = superSmartParkingBoy.parkCar(car3);
        //when
        Car actualCar1 = manager.orderFetch(parkingBoy, ticket1);
        Car actualCar2 = manager.orderFetch(smartParkingBoy, ticket2);
        Car actualCar3 = manager.orderFetch(superSmartParkingBoy, ticket3);

        //then
        assertNull(actualCar1);
        assertNull(actualCar2);
        assertNull(actualCar3);

    }

    @Test
    public void should_return_unrecognized_parking_position_error_message_when_order_fetch_given_the_ticket_is_invalid() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        List<ParkingLot> parkingLots1 = new ArrayList<>();
        List<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots1.add(parkingLot1);
        parkingLots1.add(parkingLot2);
        parkingLots2.add(parkingLot3);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots1);
        Manager manager = new Manager(parkingLots2);
        manager.addParkingBoyToList(superSmartParkingBoy);
        Ticket ticket = superSmartParkingBoy.parkCar(car);
        //when
        manager.orderFetch(superSmartParkingBoy, ticket);
        final UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {
            manager.orderFetch(superSmartParkingBoy, ticket);
        });
        //then
        assertEquals("Unrecognized parking ticket", unrecognizedParkingTicketException.getMessage());

    }

    @Test
    public void should_be_parked_once_when_park_a_car_given_a_manager() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        StandardPark standardPark = Mockito.mock(StandardPark.class);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Manager manager = new Manager(parkingLots);
        manager.setParkBehavior(standardPark);
        //when
        manager.parkCar(car);
        //then
        Mockito.verify(standardPark, Mockito.times(1)).park(car, parkingLots);
    }

}
