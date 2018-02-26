package com.isa.workshops.log4j.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BurstFilterExample {

    public static final int MAX_LOG_TIME = 10;

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j-burst-filter.xml");

        Logger logger = LogManager.getLogger(BurstFilterExample.class.getName());

        for (int i = 0; i < MAX_LOG_TIME; i++) {
            logger.error("Log: " + i);
        }
    }
}
