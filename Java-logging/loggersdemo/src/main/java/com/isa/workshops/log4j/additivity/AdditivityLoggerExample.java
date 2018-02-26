package com.isa.workshops.log4j.additivity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditivityLoggerExample {
    Logger parentLogger = LogManager.getLogger(AdditivityLoggerExample.class.getPackage().getName());
    Logger logger = LogManager.getLogger(AdditivityLoggerExample.class.getName());

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile", "log4j-additivity.xml");
        AdditivityLoggerExample additivityLoggerExample = new AdditivityLoggerExample();

        additivityLoggerExample.logger.info("This is logged info with logger {}.", additivityLoggerExample.logger.getName());
    }
}
