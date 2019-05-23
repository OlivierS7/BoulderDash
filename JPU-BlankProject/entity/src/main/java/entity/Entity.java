package entity;

import java.awt.Image;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	private int x;
	private int y;
	private Image image;
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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public final Sprite getSprite() {
		return this.sprite;
	}

	private void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}
	
	public final Image getImage() {
        return this.getSprite().getImage();
    }
}
