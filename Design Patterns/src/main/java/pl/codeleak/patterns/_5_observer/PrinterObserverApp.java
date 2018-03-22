package pl.codeleak.patterns._5_observer;

class PrinterObserverApp {

    public static void main(String[] args) {
        Printer printer = new Printer();

        // TODO Register observers with printer

        printer.addObserver(new PrinterObserver1());
        printer.addObserver(new PrinterObserver1());
        printer.addObserver(new PrinterObserver2());
        printer.addObserver(new PrinterObserver2());
        printer.addObserver(new PrinterObserver2());
        printer.addObserver(new PrinterObserver2());

        printer.print("Message 1");
        printer.print("Message 2");
        printer.print("Message 3");
        printer.print("Message 4");
        printer.print("Message 5");
    }
}


