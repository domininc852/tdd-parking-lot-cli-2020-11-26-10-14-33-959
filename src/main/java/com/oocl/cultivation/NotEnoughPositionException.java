package com.oocl.cultivation;

public class NotEnoughPositionException extends Throwable {
    public NotEnoughPositionException() {
        super("Not enough Position");
    }
}
