package com.car.tracking.util;

public class LoggerUtil {
    public static final String CYAN = "\033[0;36m";
    public static final String RESET = "\033[0m";

    public static void log(String message) {
        System.out.println(CYAN + "[TRACKER] " + RESET + message);
    }
}
