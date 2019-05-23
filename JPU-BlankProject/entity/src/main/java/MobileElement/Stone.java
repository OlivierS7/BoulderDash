package MobileElement;

import java.io.IOException;

import entity.Entity;
import entity.Sprite;

public class Stone extends MobileElement {

	static Sprite sprite = new Sprite('O', "Stone.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stone(int x, int y) {
		super(sprite, x, y);
	}

}
