package com.isa.workshops.log4j.appenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileAppenderExample {
    Logger logger = LogManager.getLogger("file-appender");

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j-appenders.xml");
        FileAppenderExample fileAppenderExample = new FileAppenderExample();

        fileAppenderExample.logger.info("This is log into the file.");
    }
}
