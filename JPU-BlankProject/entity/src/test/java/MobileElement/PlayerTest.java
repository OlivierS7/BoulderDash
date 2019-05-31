package MobileElement;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class PlayerTest {

	private char keyTyped = 'Q';
	static Sprite spriteDown = new Sprite('P', "Rockford.png");
	static Sprite spriteUp = new Sprite('P', "Back_Rockford.png");
	static Sprite spriteLeft = new Sprite('P', "Left_Rockford.png");
	static Sprite spriteRight = new Sprite('P', "Right_Rockford.png");
	private Player testPlayer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			spriteUp.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			spriteLeft.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			spriteRight.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.testPlayer = new Player(5, 5);


	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testSetSpriteUp() {
//		final Sprite expected = spriteUp;
//		assertEquals(expected, testPlayer.getSprite());
//	}
//
//	@Test
//	public void testSetSpriteDown() {
//
//		final Sprite expected = spriteDown;
//		assertEquals(expected, testPlayer.getSprite());
//	}
//
//	@Test
//	public void testSetSpriteLeft() {
//		final Sprite expected = spriteLeft;
//		assertEquals(expected, testPlayer.getSprite());
//	}
//
//	@Test
//	public void testSetSpriteRight() {
//		final Sprite expected = spriteRight;
//		assertEquals(expected, testPlayer.getSprite());
//	}

	@Test
	public void testUpdateSpritePlayer() {
		switch (keyTyped) {
		case 'Z':
			this.testPlayer.setSprite(spriteUp);

			break;
		case 'Q':
			this.testPlayer.setSprite(spriteLeft);

			break;
		case 'S':
			this.testPlayer.setSprite(spriteDown);

			break;
		case 'D':
			this.testPlayer.setSprite(spriteRight);

			break;
		default:
			break;
		}
		final Sprite expected = spriteLeft;
		assertEquals(expected, this.testPlayer.getSprite());
	}
}
