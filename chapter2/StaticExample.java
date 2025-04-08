package programming2.chapter2;

public class StaticExample {

    // Static attribute
    static int counter = 0;

    // Static block
    static {
        System.out.println("Static Block executing...");
        counter = 100; // Initial value for static attribute
    }

    // Static method
    static void printCounter() {
        System.out.println("Counter: " + counter);
    }

    // Constructor
    public StaticExample() {
        counter++; // static counter is incremented with every instance
    }

    public static void main(String[] args) {
        StaticExample obj1 = new StaticExample();
        StaticExample obj2 = new StaticExample();

        // Access to static method via the class name
        StaticExample.printCounter();
    }
}