package caunv.example;

import java.util.logging.Logger;

class Printer {
    private static final Logger logger = Logger.getLogger(Printer.class.getName());

    void print() {
        logger.info("Generating report...");
    }
}

class Report {
    private final Printer printer = new Printer();

    void generate() {
        printer.print();
    }

    public static void main(String[] args) {
        Report report = new Report();
        report.generate();
    }
}
