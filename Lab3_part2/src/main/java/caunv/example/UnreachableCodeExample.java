package caunv.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UnreachableCodeExample {

    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());
    private static final int NUMBER = 42;

    public static void main(String[] args) {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.valueOf(NUMBER));
        }
    }
}
