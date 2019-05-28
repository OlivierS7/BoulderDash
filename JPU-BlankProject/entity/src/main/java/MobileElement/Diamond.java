package MobileElement;

import java.io.IOException;

import entity.Sprite;

public class Diamond extends MobileElement {

	/** The sprite. */
	static Sprite sprite = new Sprite('D', "Diamond.png");
	
	/** The boolean to check if Diamond is falling at the moment. */
	boolean isFallen;
	
	/** Count from how far Stone is falling. */
	int falling = 0;
	
	//Getter of falling
	public int getFalling() {
		return falling;
	}

	//Setter of falling
	public void setFalling(int falling) {
		this.falling = falling;
	}

	//Getter of isFallen
	public boolean isFallen() {
		return isFallen;
	}

	//Setter of isFallen
	public void setFallen(boolean isFallen) {
		this.isFallen = isFallen;
	}

	//A static bloc which automatically load the image
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Instanciantes a Diamond
	public Diamond(int x, int y) {
		super(sprite, x, y);
		this.isFallen = false;
	}

}
