package com.isa.workshops.log4j.layouts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectArrayMessage;

public class JsonLayouts {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j-layouts.xml");
        Logger logger = LogManager.getLogger("json-layout");

        logger.info("some json message");
        logger.info(new ObjectArrayMessage("Ben", "Jack", "Philip"));
        logger.debug("one={}, two={}, three={}", 1, 2, 3);
    }
}
