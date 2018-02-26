package com.isa.workshops.log4j.examples;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.io.IoBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;


public class IOStreams {

    public static void main(String[] args) throws IOException {
        System.setProperty("log4j.configurationFile", "log4j-simple.xml");
        writeToLoggerWithPrintWriter();
        writeToLoggerWithOutputStream();
    }

    public static void writeToLoggerWithPrintWriter() throws IOException {
        PrintWriter logger = IoBuilder.forLogger(IOStreams.class)
                .setLevel(Level.TRACE)
                .buildPrintWriter();
        DriverManager.setLogWriter(logger);

        logger.write("writeToLoggerWithPrintWriter");

        logger.close();
    }

    public static void writeToLoggerWithOutputStream() throws IOException {
        OutputStream logger = IoBuilder.forLogger(IOStreams.class)
                .setLevel(Level.TRACE)
                .buildOutputStream();

        logger.write("writeToLoggerWithOutputStream".getBytes());

        logger.close();
    }
}
