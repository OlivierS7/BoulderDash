package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

public class Exit extends MotionlessElement {

	/** The sprite. */
	static Sprite sprite = new Sprite('X', "Door.png");
	
	//A static bloc which automatically load the image
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Instanciates an Exit
	public Exit(int x, int y) {
		super(sprite, x, y);
	}

}
