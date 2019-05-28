package MobileElement;

import java.io.IOException;

import entity.Sprite;

public class Stone extends MobileElement {

	/** The sprite. */
	static Sprite sprite = new Sprite('O', "Stone.png");
	
	/** The boolean to check if Stone is falling at the moment. */
	boolean isFallen;
	
	/** Count from how far Stone is falling */
	int falling = 0;
	
	//Getter of Falling
	public int getFalling() {
		return falling;
	}
	
	//Setter of Falling
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
	
	//Instanciates a Stone
	public Stone(int x, int y) {
		super(sprite, x, y);
		this.isFallen = false;
	}

}
