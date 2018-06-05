package vectortest;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import vector.IVector;
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
	
	@Test
	public void testAdd() {
		IVector a = new Vector(1, 1);
		IVector b = new Vector(2, 3);
		a.add(b);
		assertEquals(true, a.isEqual(3, 4));
	}
	
	@Test
	public void testDiv() {
		IVector a = new Vector(4, 8);
		a.div(2);
		assertEquals(true, a.isEqual(2, 4));		
	}

	@Test
	public void testGetX() {
		IVector a = new Vector(2, 3);
		assertEquals(true, a.getX() == 2);		
	}
	
	@Test
	public void testGetY() {
		IVector a = new Vector(2, 3);
		assertEquals(true, a.getY() == 3);		
	}
	
	@Test
	public void testInvert() {
		IVector a = new Vector(2, 3);
		a.invert();
		assertEquals(true, a.isEqual(-2, -3));		
	}

	@Test
	public void testMult() {
		IVector a = new Vector(2, 3);
		a.mult(2);
		assertEquals(true, a.isEqual(4, 6));
	}

	@Test
	public void testSet() {
		IVector a = new Vector(2, 3);
		a.set(6, 1);
		assertEquals(true, a.isEqual(6, 1));
	}

	@Test
	public void testSetX() {
		IVector a = new Vector(2, 3);
		a.setX(1);
		assertEquals(true, a.isEqual(1, 3));
	}
	
	@Test
	public void testSetY() {
		IVector a = new Vector(2, 3);
		a.setY(4);
		assertEquals(true, a.isEqual(2,4));
	}
	
	@Test
	public void testSub() {
		IVector a = new Vector(2, 3);
		IVector b = new Vector(4, 1);
		a.sub(b);
		assertEquals(true, a.isEqual(-2, 2));
	}
}
