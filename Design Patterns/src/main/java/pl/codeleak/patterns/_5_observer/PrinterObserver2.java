package pl.codeleak.patterns._5_observer;

public class PrinterObserver2 implements PrinterObserver {
    @Override
    public void messagePrinted(String message, int currentPrintCount) {
        System.out.println("Message printed " + message);
    }
}
