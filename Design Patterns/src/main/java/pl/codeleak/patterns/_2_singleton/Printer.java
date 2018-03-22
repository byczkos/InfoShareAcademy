package pl.codeleak.patterns._2_singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Printer {

    private static final Logger LOG = LoggerFactory.getLogger(Printer.class);
    private static Printer INSTANCE = null;

    private Printer() {
        LOG.info("Creating printer ...");
    }

    // TODO Make sure only one instance of Printer can be created


    private int printCount;

    public static Printer instance() {
        if (INSTANCE == null) {
            LOG.info("Creating new instance...");
            INSTANCE = new Printer();
        }
        return INSTANCE;
    }

    void print(String message) {
        LOG.info("Printed: {}, Count: {}", message, ++this.printCount);
    }
}
