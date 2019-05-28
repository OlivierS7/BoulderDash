package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

public class Air extends MotionlessElement {

	/** The sprite. */
	static Sprite sprite = new Sprite('A', "Background.png");
	
	//A static bloc which automatically load the image
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Instanciates an Air
	public Air(int x, int y) {
		super(sprite, x, y);
	}

}
