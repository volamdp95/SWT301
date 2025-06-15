package caunv.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchGenericExceptionExample {

    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        String s = System.getenv("MY_INPUT");

        if (s != null) {
            if (!s.isEmpty()) {
                int length = s.length();
                if (logger.isLoggable(Level.INFO)) {
                    logger.info(String.format("Length of string 's': %d", length));
                }
            } else {
                logger.warning("Variable 's' is empty. Cannot call .length().");
            }
        } else {
            logger.warning("Variable 's' is null.");
        }
    }
}


