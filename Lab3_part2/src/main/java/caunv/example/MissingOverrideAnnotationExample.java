package caunv.example;

import java.util.logging.Logger;

class Animal {
    void speak() {
        Logger logger = Logger.getLogger(Animal.class.getName());
        logger.info("Animal speaks");
    }
}

class Dog extends Animal {

    private static final Logger logger = Logger.getLogger(Dog.class.getName());

    @Override
    void speak() {
        super.speak(); // Gọi speak() của Animal để tránh warning unused
        logger.info("Dog barks");
    }
}

public class MissingOverrideAnnotationExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.speak(); // gọi để sử dụng class Dog & Animal
    }
}
