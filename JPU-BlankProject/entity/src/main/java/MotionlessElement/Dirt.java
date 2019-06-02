package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class Dirt extends MotionlessElement {

	static Sprite sprite = new Sprite('T', "Dirt.png");

	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param x
	 * @param y
	 */
	public Dirt(int x, int y) {
		super(sprite, x, y);
	}

}
