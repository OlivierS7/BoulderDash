package entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapCountExceptionTest {

	private Map map;
	
	@Before
	public void setUp() throws Exception {
		this.map = new Map();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetCount() {
		try {
			this.map.setCount(-2);
		} catch (final Exception e) {
		final String expected = "Diamond count must be positiv";
		assertEquals(expected, e.getMessage());
	}
	}

}
