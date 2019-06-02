package entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Olivier
 *
 */

public class DiamondCountTest {
	
	private boolean isDiamond;
	private Map map;
	private int count = 3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map();
		this.map.setCount(count);
		this.isDiamond = true;
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method use to test the method setCount
	 */
	@Test
	public void testSetCount() {
		if(isDiamond) {
		this.map.setCount(this.map.getCount() + 1);
		}
		final int expected = 4;
		assertEquals(expected, this.map.getCount());
	}
	

}