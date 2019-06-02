package MotionlessElement;

import java.io.IOException;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class Wall extends MotionlessElement {

	static Sprite sprite = new Sprite('W', "Wall.png");

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
	public Wall(int x, int y) {
		super(sprite, x, y);
	}

}
