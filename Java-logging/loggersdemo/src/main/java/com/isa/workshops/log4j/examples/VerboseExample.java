package com.isa.workshops.log4j.examples;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerboseExample {

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j-examples.xml");

        Logger logger = LogManager.getLogger(VerboseExample.class.getName());

        Level VERBOSE = Level.forName("VERBOSE", 550);

        logger.log(VERBOSE, "This is VERBOSE log.");
    }
}
