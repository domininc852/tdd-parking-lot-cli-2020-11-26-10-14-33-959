package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingExceptionTest {
    @Test
    public void should_return_error_message_when_park_car_given_parking_slot_no_available_slot(){
        //given
        ParkingLot parkingLot=new ParkingLot(0);
        Car car =new Car();
        //when
        final NotEnoughPosition notEnoughPosition=assertThrows(NotEnoughPosition.class,()->{
            parkingLot.park(car);
        });
        assertEquals("Not enough Postion",notEnoughPosition.getMessage());
        //then
    }
}
