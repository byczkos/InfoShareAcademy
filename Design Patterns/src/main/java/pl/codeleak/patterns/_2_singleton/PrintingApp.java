package pl.codeleak.patterns._2_singleton;

class PrintingApp {

    public static void main(String[] args) {

        Printer printer = Printer.instance();

        // TODO Inject printer instance to PrintHouse
        PrintHouse printHouse = new PrintHouse(printer);
        printHouse.print("Text to print 1");
        printHouse.print("Text to print 2");
        printHouse.print("Text to print 3");
        printHouse.print("Text to print 4");
        printHouse.print("Text to print 5");

        PrintHouse printHouse2 = new PrintHouse(Printer.instance());
        printHouse2.print("Text 1");
        printHouse2.print("Text 2");
        printHouse2.print("Text 3");
        printHouse2.print("Text 4");
        printHouse2.print("Text 5");

    }
}

