package com.jinux.agilejava.utils;

public class StringUtil {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtil() { }


    public static String line(String str) {
        return str + NEWLINE;
    }
}
