package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetMessageTest {
	private Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWinMessage() {
		final String expected = "Thanks you for playing at our game. We hope that you will come back soon ! =)\nRestart the game to play on another map !";
		assertEquals(expected, this.model.getWinMessage());
	}

	@Test
	public void testGetLostTimeMessage() {
		final String expected = "Time run out... =(\nRestart the game to play on another map !";
		assertEquals(expected, this.model.getLostTimeMessage());
	}

	@Test
	public void testGetLostDeadMessage() {
		final String expected = "You're dead !!\n Restart the game to try again !";
		assertEquals(expected, this.model.getLostDeadMessage());
	}

}
