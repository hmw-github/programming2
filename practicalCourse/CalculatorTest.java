package practicalCourse;
import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		assertEquals("10 + 20 should be 30",
				c.add(10, 20), 30);
	}

	@Test
	public void testSub() {
		Calculator c = new Calculator();
		assertEquals("10 + 20 should be 30",
				c.sub(10, 20), -10);
	}

}
