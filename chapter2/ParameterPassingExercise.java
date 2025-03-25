package programming2.chapter2;
class Counter {
	int value = 42;
}

class Example {
	public void doSomething(Counter a, int x) {
		a.value = a.value + 1;
		x = x + 1;
	}
}

public class ParameterPassingExercise {
	public static void main(String[] args) {
		Counter foo = new Counter();
		Example ex = new Example();
		int xx = 17;
		ex.doSomething(foo, xx);
		System.out.println(foo.value);
		System.out.println(xx);
	}
}
