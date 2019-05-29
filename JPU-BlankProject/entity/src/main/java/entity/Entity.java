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

	public Entity(final Sprite sprite, final int x, final int y) {
		this.setSprite(sprite);
		this.x = x;
		this.y = y;
	}

	public Entity() {

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public final Sprite getSprite() {
		return this.sprite;
	}

	public void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return
	 */
	public final Image getImage() {
		return this.getSprite().getImage();
	}
}
