package MobileElement;

import java.io.IOException;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class Ennemy extends MobileElement {

	static Sprite spriteDown = new Sprite('E', "Ennemy.png");
	static Sprite spriteUp = new Sprite('E', "Ennemy.png");
	static Sprite spriteRight = new Sprite('E', "Ennemy.png");
	static Sprite spriteLeft = new Sprite('E', "Ennemy.png");

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
		Ennemy.spriteUp = spriteUp;
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
		Ennemy.spriteDown = spriteDown;
	}

	/**
	 * @return if the ennemy is alive
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
		Ennemy.spriteRight = spriteRight;
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
		Ennemy.spriteLeft = spriteLeft;
	}

	/**
	 * @param x
	 * @param y
	 */
	public Ennemy(int x, int y) {
		super(spriteDown, x, y);
	}

	/**
	 * Method use to update Sprite Ennemy
	 */
	public void updateSpriteEnnemy() {
		this.setSprite(Ennemy.spriteUp);
		try {
			spriteUp.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setSprite(Ennemy.spriteDown);
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setSprite(Ennemy.spriteRight);
		try {
			spriteRight.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setSprite(Ennemy.spriteLeft);
		try {
			spriteLeft.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
