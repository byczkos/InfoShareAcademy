package com.isa.workshops.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EffectiveLevelExample {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(EffectiveLevelExample.class.getName());

//        logger.setLevel(Level.WARNING);
        logger.log(Level.INFO, "Effective Level Example Log");
    }
}
