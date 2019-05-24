package MobileElement;

import entity.Entity;
import entity.Sprite;

public class MobileElement extends Entity{
	
	public MobileElement(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

}
