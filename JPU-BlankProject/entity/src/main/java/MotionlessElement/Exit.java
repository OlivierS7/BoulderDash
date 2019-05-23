package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

public class Exit extends MotionlessElement {

	static Sprite sprite = new Sprite('X', "Door.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Exit(int x, int y) {
		super(sprite, x, y);
	}

}
