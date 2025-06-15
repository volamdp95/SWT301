package caunv.example;

import java.util.logging.Logger;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    Logger logger = Logger.getLogger(getClass().getName());
    @Override
    public void draw() {
        logger.info("Drawing a circle");
    }

    public static void main(String[] args) {
        Drawable shape = new Circle();
        shape.draw();
    }
}
