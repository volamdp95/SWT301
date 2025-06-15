package caunv.example;

import java.util.logging.Logger;
import java.util.logging.Level;

interface Shape {
    void draw();
    void resize();
}

class Square implements Shape {
    private static final Logger logger = Logger.getLogger(Square.class.getName());

    @Override
    public void draw() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Drawing square");
        }
    }

    @Override
    public void resize() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Resizing square");
        }
    }

    public static void main(String[] args) {
        Shape shape = new Square();
        shape.draw();
        shape.resize();
    }
}
