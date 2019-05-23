package MobileElement;

import java.io.IOException;

import entity.Entity;
import entity.Sprite;

public class Ennemy extends MobileElement {

	static Sprite sprite = new Sprite('E', "Ennemy.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Ennemy(int x, int y) {
		super(sprite, x, y);
	}

}
