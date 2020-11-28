package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    @Test
    public void should_be_parked_once_when_park_a_car_given_a_smart_parking_boy() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        SmartPark smartPark = Mockito.mock(SmartPark.class);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        smartParkingBoy.setParkBehavior(smartPark);
        //when
        smartParkingBoy.parkCar(car);
        //then
        Mockito.verify(smartPark, Mockito.times(1)).park(car, parkingLots);
    }
}
