package MobileElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.EntityTest;

public class StoneTest extends EntityTest {

	private int x = 10;
	private int y = 10;
	private String image = "Stone.png";
	private char character = 'O';
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.entity = new Stone(x,y);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testStone() {
		super.testEntitySpriteIntInt();
		assertEquals(x, this.entity.getX());
		assertEquals(y, this.entity.getY());
		assertEquals(image, this.entity.getSprite().getImageName());
		assertEquals(character, this.entity.getSprite().getConsoleImage());
	}


}
