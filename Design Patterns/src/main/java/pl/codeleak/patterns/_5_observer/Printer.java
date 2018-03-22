package pl.codeleak.patterns._5_observer;

import java.util.ArrayList;
import java.util.List;

class Printer {

    private int printCount = 0;

    private List<PrinterObserver> observers = new ArrayList<>();

    void addObserver(PrinterObserver printerObserver) {
        observers.add(printerObserver);
    }

    void print(String message) {
        System.out.println("Printing message " + message);
        ++printCount;
        // TODO Print and notify all observers. Observers should receive the message printed and the current print count
        observers.forEach(o -> o.messagePrinted(message, printCount));
    }
}
