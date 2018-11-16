package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Polymorphism {
    class Parent {
        String getN() {
            return getName();
        }

        String getName() {
            return "hello";
        }
    }

    class Child extends Parent {
        @Override
        String getName() {
            return "DDD";
        }
    }

    @Test
    void testOverlayMethod() {
        Parent p = new Child();
        assertEquals(p.getN(), "DDD");
    }
}
