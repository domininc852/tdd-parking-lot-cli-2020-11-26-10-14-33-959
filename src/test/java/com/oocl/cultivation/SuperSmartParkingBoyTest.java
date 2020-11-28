package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_be_parked_once_when_park_a_car_given_a_smart_parking_boy() throws NotEnoughPositionException {
        //given
        Car car = new Car();
        SuperSmartPark superSmartPark = Mockito.mock(SuperSmartPark.class);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.setParkBehavior(superSmartPark);
        //when
        superSmartParkingBoy.parkCar(car);
        //then
        Mockito.verify(superSmartPark, Mockito.times(1)).park(car, parkingLots);
    }
}
