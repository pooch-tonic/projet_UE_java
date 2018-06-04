package factoriesTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.factories.VectorFactory;
import vector.Vector;

public class VectorFactoryTest {

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
	public void testDown() {
		Vector vector = new Vector(0, 1);
		assertEquals(true, VectorFactory.getDOWN().isEqual(vector));
	}

	@Test
	public void testDownLeft() {
		Vector vector = new Vector(-1, 1);
		assertEquals(true, VectorFactory.getDOWNLEFT().isEqual(vector));
	}

	@Test
	public void testDownRight() {
		Vector vector = new Vector(1, 1);
		assertEquals(true, VectorFactory.getDOWNRIGHT().isEqual(vector));
	}

	@Test
	public void testLeft() {
		Vector vector = new Vector(-1, 0);
		assertEquals(true, VectorFactory.getLEFT().isEqual(vector));
	}

	@Test
	public void testMiddle() {
		Vector vector = new Vector(0, 0);
		assertEquals(true, VectorFactory.getMIDDLE().isEqual(vector));
	}

	@Test
	public void testRight() {
		Vector vector = new Vector(1, 0);
		assertEquals(true, VectorFactory.getRIGHT().isEqual(vector));
	}

	@Test
	public void testUp() {
		Vector vector = new Vector(0, -1);
		assertEquals(true, VectorFactory.getUP().isEqual(vector));
	}

	@Test
	public void testUpLeft() {
		Vector vector = new Vector(-1, -1);
		assertEquals(true, VectorFactory.getUPLEFT().isEqual(vector));
	}

	@Test
	public void testUpRight() {
		Vector vector = new Vector(1, -1);
		assertEquals(true, VectorFactory.getUPRIGHT().isEqual(vector));
	}

}
