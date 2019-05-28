package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

public class Wall extends MotionlessElement {
	
	/** The sprite. */
	static Sprite sprite = new Sprite('W', "Wall.png");
	
	//A static bloc which automatically load the image
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Instanciates a Wall
	public Wall(int x, int y) {
		super(sprite, x, y);
	}

}
