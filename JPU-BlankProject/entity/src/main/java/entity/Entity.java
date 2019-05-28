package entity;

import java.awt.Image;

public abstract class Entity {
	protected int x;
	protected int y;
	private Sprite sprite;

	//Instanciates an entity
	public Entity(final Sprite sprite, final int x, final int y) {
		this.setSprite(sprite);
		this.x = x;
		this.y = y;
	}

	public Entity() {
		
	}
	
	//Getter of X
	public int getX() {
		return x;
	}

	//Getter of Y
	public int getY() {
		return y;
	}

	//Getter of Sprite
	public final Sprite getSprite() {
		return this.sprite;
	}

	//Setter of Sprite
	public void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}
	
	//Getter of Image
	public final Image getImage() {
        return this.getSprite().getImage();
    }
}
