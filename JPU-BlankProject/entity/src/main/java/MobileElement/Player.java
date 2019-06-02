package MobileElement;

import java.io.IOException;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class Player extends MobileElement {

	static Sprite spriteDown = new Sprite('P', "Rockford.png");
	static Sprite spriteUp = new Sprite('P', "Back_Rockford.png");
	static Sprite spriteLeft = new Sprite('P', "Left_Rockford.png");
	static Sprite spriteRight = new Sprite('P', "Right_Rockford.png");

	boolean isAlive = true;

	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return SpriteUp
	 */
	public static Sprite getSpriteUp() {
		return spriteUp;
	}

	/**
	 * @param spriteUp
	 */
	public static void setSpriteUp(Sprite spriteUp) {
		Player.spriteUp = spriteUp;
	}

	/**
	 * @return SpriteDown
	 */
	public static Sprite getSpriteDown() {
		return spriteDown;
	}

	/**
	 * @param spriteDown
	 */
	public static void setSpriteDown(Sprite spriteDown) {
		Player.spriteDown = spriteDown;
	}

	/**
	 * @return SpriteLeft
	 */
	public static Sprite getSpriteLeft() {
		return spriteLeft;
	}

	/**
	 * @param spriteLeft
	 */
	public static void setSpriteLeft(Sprite spriteLeft) {
		Player.spriteLeft = spriteLeft;
	}

	/**
	 * @return SpriteRight
	 */
	public static Sprite getSpriteRight() {
		return spriteRight;
	}

	/**
	 * @param spriteRight
	 */
	public static void setSpriteRight(Sprite spriteRight) {
		Player.spriteRight = spriteRight;
	}

	/**
	 * @param x
	 * @param y
	 */
	public Player(int x, int y) {
		super(spriteDown, x, y);
	}

	/**
	 * Method use to update Sprite Player
	 * @param keyTyped
	 */
	public void updateSpritePlayer(char keyTyped) {
		switch (keyTyped) {
		case 'Z':
			this.setSprite(Player.spriteUp);
			try {
				spriteUp.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'Q':
			this.setSprite(Player.spriteLeft);
			try {
				spriteLeft.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'S':
			this.setSprite(Player.spriteDown);
			try {
				spriteDown.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'D':
			this.setSprite(Player.spriteRight);
			try {
				spriteRight.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

	/**
	 * @return if the player is alive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
