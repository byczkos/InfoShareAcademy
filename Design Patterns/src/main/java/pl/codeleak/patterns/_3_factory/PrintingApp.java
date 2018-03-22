package pl.codeleak.patterns._3_factory;

import java.util.ArrayList;
import java.util.List;

public class PrintingApp {

    public static void main(String[] args) {

        List<Printer> printers = new ArrayList<>(5);

        // TODO Create 2 instances of InkPrinter and add to printers
        printers.add(PrinterFactory.createPrinter(PrinterFactory.INK));
        printers.add(PrinterFactory.createPrinter(PrinterFactory.INK));

        // TODO Create 1 instance of DotMatrixPrinter and add to printers
        printers.add(PrinterFactory.createPrinter(PrinterFactory.DOT_MATRIX));

        // TODO Create 2 instances of LaserPrinter and add to printers
        printers.add(PrinterFactory.createPrinter(PrinterFactory.LASER_PRINTER));


        printers.add(PrinterFactory.createPrinter(PrinterFactory._3D));



        final String message = "Factory message";

        printers.forEach(
                m -> m.print(message)
        );
    }
}
