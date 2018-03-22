package pl.codeleak.patterns._3_factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DotMatrixPrinter implements Printer {

    private static final Logger LOG = LoggerFactory.getLogger(DotMatrixPrinter.class);

    @Override
    public void print(String message) {
        LOG.info("Printing... " + message);
    }
}
