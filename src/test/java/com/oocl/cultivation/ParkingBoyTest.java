package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    void should_be_parked_once_when_park_a_car_given_car_parking_boy_parking_slot_with_available_slot() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        parkingBoy.park(car);
        //then
        Mockito.verify(parkingLot, times(1)).park(car);

    }
}
