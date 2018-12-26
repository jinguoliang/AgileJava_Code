package com.jinux.agilejava.playground;

public class SimpleException extends RuntimeException {
    public SimpleException() {
        super("Somebody should catch this!");
    }
}
