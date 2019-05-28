package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

public class Dirt extends MotionlessElement {

	/** The sprite. */
	static Sprite sprite = new Sprite('T', "Dirt.png");
	
	//A static bloc which automatically load the image
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Instanciates a Dirt
	public Dirt(int x, int y) {
		super(sprite, x, y);
	}

}
