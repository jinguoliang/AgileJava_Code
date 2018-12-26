package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;

public class ExceptionTest {
    @Test
    void testReturnInFinish() throws MalformedURLException {
        try {
            new URL("hello");

        } catch (MalformedURLException e) {
            log("haha");
            fail();
        } finally {
            log("hello");
            return;
        }
    }

    private void log(String haha) {
        Logger.getGlobal().log(Level.ALL, haha);
    }
}
