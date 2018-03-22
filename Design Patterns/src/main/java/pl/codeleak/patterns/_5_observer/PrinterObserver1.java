package pl.codeleak.patterns._5_observer;

public class PrinterObserver1 implements PrinterObserver {
    @Override
    public void messagePrinted(String message, int currentPrintCount) {
        System.out.println("I am observer 1");
    }
}
