package pl.codeleak.patterns._3_factory;

class PrinterFactory {

    public static final String INK = "InkPrinter";
    public static final String DOT_MATRIX = "DotMatrixPrinter";
    public static final String LASER_PRINTER = "LaserPrinter";
    public static final String _3D = "3D";

    // TODO Basic implementation
    static Printer createPrinter(String printerType) {
        switch (printerType) {
            case PrinterFactory.INK:
                return new InkPrinter();
            case PrinterFactory.DOT_MATRIX:
                return new DotMatrixPrinter();
            case PrinterFactory.LASER_PRINTER:
                return new LaserPrinter();
            case PrinterFactory._3D:
                return new ThreeDPrinter();
            default:
                throw new IllegalArgumentException("Unknown printer type");
        }
    }

    // TODO Generic implementation with reflection
}
