package MobileElement;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.EntityTest;

/**
 * @author Olivier
 *
 */
public class PlayerTest extends EntityTest {

	private int x = 10;
	private int y = 10;
	private String image = "Rockford.png";
	private char character = 'P';
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.entity = new Player(x,y);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testPlayer() {
		super.testEntitySpriteIntInt();
		assertEquals(x, this.entity.getX());
		assertEquals(y, this.entity.getY());
		assertEquals(image, this.entity.getSprite().getImageName());
		assertEquals(character, this.entity.getSprite().getConsoleImage());
	}

}
