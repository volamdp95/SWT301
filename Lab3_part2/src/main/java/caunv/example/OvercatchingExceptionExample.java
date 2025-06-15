package caunv.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OvercatchingExceptionExample {

    private static final Logger logger = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            if (logger.isLoggable(Level.INFO)) {
                logger.info("Attempting to access arr[10]");
                logger.info(String.valueOf(arr[10]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Runtime error: Array index out of bounds", e);
        }
    }
}
