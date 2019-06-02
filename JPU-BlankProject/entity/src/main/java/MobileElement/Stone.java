package MobileElement;

import java.io.IOException;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class Stone extends MobileElement {

	static Sprite sprite = new Sprite('O', "Stone.png");

	boolean isFallen;

	int falling = 0;

	/**
	 * @return Height of the falling
	 */
	public int getFalling() {
		return falling;
	}

	/**
	 * @param falling
	 */
	public void setFalling(int falling) {
		this.falling = falling;
	}

	/**
	 * @return if the Stone is falling
	 */
	public boolean isFallen() {
		return isFallen;
	}

	/**
	 * @param isFallen
	 */
	public void setFallen(boolean isFallen) {
		this.isFallen = isFallen;
	}

	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param x
	 * @param y
	 */
	public Stone(int x, int y) {
		super(sprite, x, y);
		this.isFallen = false;
	}

}
