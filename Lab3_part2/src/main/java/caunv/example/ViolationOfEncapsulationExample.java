package caunv.example;

import java.util.logging.Logger;
import java.util.logging.Level;
class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void display() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Name: %s, Age: %d", name, age));
        }
    }

    public static void main(String[] args) {
        User u = new User("Alice", 22);
        u.display();
    }
}
