package programming2.chapter6;

 class Car implements Comparable<Car>{
	public int compareTo(Car o) {
		return 0;
	}	 
 }

// store only objects that implement Comparable
public class Box<T extends Comparable<T>> {
	private T wert;
	
	public Box(T wert) {
		this.wert = wert;
	}

	public void setWert(T wert) {
		this.wert = wert;
	}
	
	public T getWert() {
		return wert;
	}
	
	public String toString() {
		return String.valueOf(wert);
	}
	
    public static void main(String[] args) {
        Box<String> w1 = new Box<>("Hello");
        Box<Integer> w2 = new Box<>(4);
        Box<Car> w3 = new Box<>(new Car());
        w2.setWert(w2.getWert() + 5);
        System.out.println(w1 + ", " + w2); // Output using toString()
    }
}
