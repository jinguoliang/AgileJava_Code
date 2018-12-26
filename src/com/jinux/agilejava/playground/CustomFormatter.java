package com.jinux.agilejava.playground;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    private CountingLogHandler handler = null;

    public CustomFormatter() {}

    public CustomFormatter(CountingLogHandler handler) {
        this.handler = handler;
    }

    @Override
    public String format(LogRecord logRecord) {

        StringBuilder builder = new StringBuilder()
                .append("jin---")
                .append(logRecord.getLevel())
                .append(": ")
                .append(logRecord.getMessage());

        if (this.handler != null) {
            builder.append(" (")
                    .append(logRecord.getLevel())
                    .append(" total = ")
                    .append(this.handler.map.getOrDefault(logRecord.getLevel(), 0))
                    .append(")\n");
        } else {
            builder.append("\n");
        }

        return builder.toString();
    }
}
