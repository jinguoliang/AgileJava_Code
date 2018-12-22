package com.jinux.agilejava.studensystem.studentinfo;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TestHandler extends Handler {
    private LogRecord record;

    @Override
    public void publish(LogRecord logRecord) {
        this.record = logRecord;
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }

    String getMessage() {
        return record.getMessage();
    }
}
