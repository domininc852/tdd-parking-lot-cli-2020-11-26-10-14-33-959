package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

class ParkingBoyTest {
    @Test
    void should_be_parked_once_when_park_a_car_given_car_parking_boy_parking_slot_with_available_slot() {
        //given
        Car car = new Car();
        ParkingSlot parkingSlot = new ParkingSlot();
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        parkingBoy.park();
        //then
        Mockito.verify(parkingSlot,times(1)).park();

    }
}
