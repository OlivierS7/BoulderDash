package MobileElement;

import entity.Entity;
import entity.Sprite;

public class MobileElement extends Entity{
	
	//Instanciates a MobileElement
	public MobileElement(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	//Setter of X
	public void setX(int x) {
		this.x = x;
	}
	
	//Setter of Y
	public void setY(int y) {
		this.y = y;
	}

}
