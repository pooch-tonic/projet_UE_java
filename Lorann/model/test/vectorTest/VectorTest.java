package vectorTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vector.Vector;

public class VectorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateLength() {
		Vector a = new Vector(3, 5);
		Double expectedDouble = Math.sqrt(34);
		Float expectedFloat = expectedDouble.floatValue();
		assertEquals(expectedFloat, a.calculateLength());
	}

	@Test
	public void testIsEqual() {
		Vector a = new Vector(1, 2);
		Vector b = new Vector(1, 2);
		assertEquals(true, a.isEqual(b));
	}

	@Test
	public void testNormalize() {
		Vector a = new Vector(-5, 2);
		Vector b = new Vector(8, 0);
		Vector c = new Vector(-8, -6);
		a.normalize();
		b.normalize();
		c.normalize();

		assertEquals(true, a.isEqual(-1, 1));
		assertEquals(true, b.isEqual(1, 0));
		assertEquals(true, c.isEqual(-1, -1));
	}
}
