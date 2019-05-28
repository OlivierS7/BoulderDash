package entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {
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
		this.isDiamond = false;
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testGetCount() {	
//	final int expected = 1;
//	assertEquals(expected, this.count);
//	}

	@Test
	public void testSetCount() {
		if(isDiamond) {
		count ++;
		this.map.setCount(count);
		}else{

		}
		final int expected = 3;
		assertEquals(expected, this.map.getCount());
//		final int expected = 4;
//		assertEquals(expected, this.map.getCount());
	}
	

}