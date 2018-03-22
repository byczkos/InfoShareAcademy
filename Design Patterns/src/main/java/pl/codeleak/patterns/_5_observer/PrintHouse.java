package pl.codeleak.patterns._5_observer;

class PrintHouse {

    private Printer printer;

    public PrintHouse(Printer printer) {
        this.printer = printer;
    }

    void print(String value) {
        printer.print(value);
    }
}
