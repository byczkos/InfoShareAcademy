package pl.codeleak.patterns._5_observer;

/**
 * Object that wants to be notified about printing needs to implement this interface
 * and it must be registered with {@link Printer}
 */
interface PrinterObserver {
    void messagePrinted(String message, int currentPrintCount);
}
