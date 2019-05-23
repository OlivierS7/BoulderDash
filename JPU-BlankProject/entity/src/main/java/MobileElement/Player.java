package MobileElement;

import java.io.IOException;

import entity.Entity;
import entity.Sprite;

public class Player extends MobileElement {

	static Sprite sprite = new Sprite('P', "Rockford.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Player(int x, int y) {
		super(sprite, x, y);
	}

}
