package MobileElement;

import entity.Entity;
import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class MobileElement extends Entity {

	/**
	 * @param sprite
	 * @param x
	 * @param y
	 */
	public MobileElement(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

}
