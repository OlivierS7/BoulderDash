package MobileElement;

import java.io.IOException;

import entity.Sprite;

/**
 * @author Olivier
 *
 */
public class Diamond extends MobileElement {

	static Sprite sprite1 = new Sprite('D', "Front_Diamond.png");
	static Sprite sprite2 = new Sprite('D', "Full_Diamond.png");
	static Sprite sprite3 = new Sprite('D', "Left_Diamond.png");
	static Sprite sprite4 = new Sprite('D', "Right_Diamond.png");
	
	int anim = 1;

	boolean isFallen;

	int falling = 0;

	/**
	 * @return Height of the falling
	 */
	public int getFalling() {
		return falling;
	}

	/**
	 * @param falling
	 */
	public void setFalling(int falling) {
		this.falling = falling;
	}

	/**
	 * @return if the Diamond is falling
	 */
	public boolean isFallen() {
		return isFallen;
	}

	/**
	 * @param isFallen
	 */
	public void setFallen(boolean isFallen) {
		this.isFallen = isFallen;
	}

	static {
		try {
			sprite1.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param x
	 * @param y
	 */
	public Diamond(int x, int y) {
		super(sprite1, x, y);
		this.isFallen = false;
	}

	public void updateSpriteDiamond() {
		switch (getAnim()) {
		case 1:
			this.setSprite(sprite1);
			try {
				sprite1.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			this.setSprite(sprite2);
			try {
				sprite2.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			this.setSprite(sprite3);
			try {
				sprite3.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			this.setSprite(sprite4);
			try {
				sprite4.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		setAnim((getAnim()+1)%4);
	}

	public static Sprite getSprite1() {
		return sprite1;
	}

	public static void setSprite1(Sprite sprite1) {
		Diamond.sprite1 = sprite1;
	}

	public static Sprite getSprite2() {
		return sprite2;
	}

	public static void setSprite2(Sprite sprite2) {
		Diamond.sprite2 = sprite2;
	}

	public static Sprite getSprite3() {
		return sprite3;
	}

	public static void setSprite3(Sprite sprite3) {
		Diamond.sprite3 = sprite3;
	}

	public static Sprite getSprite4() {
		return sprite4;
	}

	public static void setSprite4(Sprite sprite4) {
		Diamond.sprite4 = sprite4;
	}

	public int getAnim() {
		return anim;
	}

	public void setAnim(int anim) {
		this.anim = anim;
	}

}
