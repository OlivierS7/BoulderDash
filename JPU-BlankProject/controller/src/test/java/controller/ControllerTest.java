package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	private Controller controller;
	
	@Before
	public void setUp() throws Exception {
		this.controller = new Controller();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMessage() {
		String expected = "Welcome to our BoulderDash game !\n"
				+ "The game's protagonist is called Rockford and this is your character.\n"
				+ "You must dig through caves collecting diamonds (minimum 10) and reach the exit within a time limit,\n"
				+ "while avoiding various types of dangerous creatures as well as obstacles like falling rocks and the constant danger of being crushed or trapped by an avalanche. \n\n"
				+ "Please choose a map : 1, 2, 3, 4 or 5";
		assertEquals(expected, this.controller.getMessage());
	}

}
