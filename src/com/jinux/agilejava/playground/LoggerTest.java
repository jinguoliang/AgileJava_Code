package com.jinux.agilejava.playground;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTest {
    @Test
    public void handleLog() {
        Logger global = Logger.getGlobal();
        global.setLevel(Level.ALL);

        CountingLogHandler countingLogHandler = new CountingLogHandler();

        global.addHandler(countingLogHandler);

        global.info("haha");
        global.fine("daad");
        global.fine("daad");
        assertEquals(1, (int) countingLogHandler.map.get(Level.INFO));
        assertEquals(2, (int) countingLogHandler.map.get(Level.FINE));
    }
}

