package com.jinux.agilejava.playground;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CountingLogHandler extends Handler {
    Map<Level, Integer> map = new HashMap<>();

    public CountingLogHandler() {
        setFormatter(new CustomFormatter(this));
    }

    @Override
    public void publish(LogRecord logRecord) {
        map.put(logRecord.getLevel(), map.getOrDefault(logRecord.getLevel(), 0) + 1);
        System.err.printf(getFormatter().format(logRecord));
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
