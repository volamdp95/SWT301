package caunv.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLInjectionExample {

    private static final Logger logger = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR '1'='1";
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Executing query: %s", query));
        }
    }
}
