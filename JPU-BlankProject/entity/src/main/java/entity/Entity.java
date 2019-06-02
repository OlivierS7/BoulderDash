package entity;

import java.awt.Image;

/**
 * @author Olivier
 *
 */
public abstract class Entity {
	protected int x;
	protected int y;
	private Sprite sprite;

	/**
	 * @param sprite
	 * @param x
	 * @param y
	 */
	public Entity(final Sprite sprite, final int x, final int y) {
		this.setSprite(sprite);
		this.x = x;
		this.y = y;
	}

	public Entity() {

	}

	/**
	 * @return X
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return Sprite
	 */
	public final Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Set the sprite 
	 * @param sprite
	 */
	public void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the image
	 */
	public final Image getImage() {
		return this.getSprite().getImage();
	}
}
