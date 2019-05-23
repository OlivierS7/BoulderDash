package MotionlessElement;

import java.io.IOException;

import entity.Entity;
import entity.Sprite;

public class Air extends MotionlessElement {

	static Sprite sprite = new Sprite('A', "Background.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Air(int x, int y) {
		super(sprite, x, y);
	}

}
