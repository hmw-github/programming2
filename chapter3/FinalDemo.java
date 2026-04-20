package chapter3;

public final class FinalDemo { // cannot be specialized

	// readonly after initialization 
    private final String owner; 
    private int counter = 0;

    public FinalDemo(final String owner) {
        this.owner = owner;
    }

    // cannot be redefined in a subclass
    public final String getOwner() {
        return owner;
    }

    public void addItem(final String item) {
        counter++;
        // item = "aaa"; not possible
    }

    public void demonstrateLocalFinal() {
    	// readonly after initialization
        final int maxRetries = 5;

        for (int i = 0; i < maxRetries; i++) {
            final String msg = "Attempt " + i;
            System.out.println(msg);
        }
    }

    public Runnable createLogger() {
        final String prefix = "[LOG] ";
        return () -> System.out.println(prefix + owner);
    }

    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo("Anna");
        demo.addItem("apple");
        demo.addItem("banana");
        demo.demonstrateLocalFinal();
        demo.createLogger().run();
    }
}