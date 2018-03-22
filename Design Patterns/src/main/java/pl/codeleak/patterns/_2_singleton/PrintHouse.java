package pl.codeleak.patterns._2_singleton;

class PrintHouse {

    private Printer printer;

    PrintHouse(Printer printer) {
        this.printer = printer;
    }

    void print(String message) {
        printer.print(message);
    }
}
