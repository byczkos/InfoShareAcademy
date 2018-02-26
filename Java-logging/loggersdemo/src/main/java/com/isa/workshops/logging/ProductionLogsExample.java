package com.isa.workshops.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductionLogsExample {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(ProductionLogsExample.class.getName());

        while (true) {
            logger.log(Level.INFO, "Simple production log.");
            new Throwable().printStackTrace();
        }
    }
}
