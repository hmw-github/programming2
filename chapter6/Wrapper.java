package chapter6;

public class Wrapper<A> extends Object {
	// Attribute
	private A value;
	
	// CTOR
	public Wrapper(A value) {
		this.value = value;
	}
	
	// getters/setters
	public A getValue() {
		return value;
	}

	public void setValue(A value) {
		this.value = value;
	}
	
	// toString
	public String toString() {
		return value.toString();
	}
	
    public static void main(String[] args) {
        Wrapper<String> w1 = new Wrapper<>("Hello");
        Wrapper<Integer> w2 = new Wrapper<>(4);
        Wrapper<Student> w3 = new Wrapper<>(new Student("Anna", 123));
        w2.setValue(w2.getValue() + 5);
        System.out.println(w1 + ", " + w2); // Output using toString()
        System.out.println(w3);
    }

}
