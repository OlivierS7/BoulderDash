package MobileElement;

import java.io.IOException;

import entity.Entity;
import entity.Sprite;

public class Diamond extends MobileElement {

	static Sprite sprite = new Sprite('D', "Diamond.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Diamond(int x, int y) {
		super(sprite, x, y);
	}

}
