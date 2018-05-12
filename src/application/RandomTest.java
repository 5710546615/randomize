package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the RandomNumber using JUnit. This is a JUnit 5 test suite.
 * 
 * @author Visurt Anuttivong
 */
public class RandomTest {

	private RandomNumber rn;

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	/** Easy test that the RandomNumber constructors are working. */
	@Test
	public void testInitialize() {
		rn = new RandomNumber(1, 3);

		assertEquals(1, rn.getMin());
		assertEquals(3, rn.getMax());
		assertNull(rn.getRands());
	}

	/** Easy test that the set methods in RandomNumber are working. */
	@Test
	public void testSetMethod() {
		rn = new RandomNumber(1, 10);

		rn.setMin(5);
		assertEquals(5, rn.getMin());

		rn.setMax(20);
		assertEquals(20, rn.getMax());

		rn.setRands(new ArrayList<Integer>());
		assertNotNull(rn.getRands());
	}

	/** Random number should contains all number between min and max. */
	@Test
	public void testRandom() {
		rn = new RandomNumber(1, 5);

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		for (int i = 0; i < 100; i++) {
			assertTrue(list.contains(rn.getRandomed()));
		}
	}

	/**
	 * Random number with no repeat should contains all number between min and max.
	 */
	@Test
	public void testRandomNoRepeat() {
		rn = new RandomNumber(1, 5);
		rn.setRands(new ArrayList<Integer>());

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		for (int i = 0; i < 100; i++) {
			rn.getRandomed();
		}

		Collections.sort(rn.getRands());
		assertEquals(list, rn.getRands());
	}
}
