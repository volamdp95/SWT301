package caunv.example;

import java.util.logging.Logger;

public class NullPointerExample {

    private static final Logger logger = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = System.getenv("TEXT");

        if (text != null && !text.isEmpty()) {
            logger.info("Text is not empty");
        }
    }
}
