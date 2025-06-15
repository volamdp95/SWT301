package caunv.example;

import java.util.logging.Logger;


final class AppConstants {
    public static final int MAX_USERS = 100;

    private AppConstants() {
        throw new UnsupportedOperationException("Utility class");
    }
}

public class InterfaceFieldModificationExample {

    private static final Logger logger = Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        logger.info("Max users allowed: " + AppConstants.MAX_USERS);
    }
}

