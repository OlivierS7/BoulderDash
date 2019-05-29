package MobileElement;

import java.io.IOException;

import entity.Sprite;

public class Player extends MobileElement {

	static Sprite spriteDown = new Sprite('P', "Rockford.png");
	static Sprite spriteUp = new Sprite('P', "Back_Rockford.png");
	static Sprite spriteLeft = new Sprite('P', "Left_Rockford.png");
	static Sprite spriteRight = new Sprite('P', "Right_Rockford.png");

	boolean isAlive = true;

	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Sprite getSpriteUp() {
		return spriteUp;
	}

	public static void setSpriteUp(Sprite spriteUp) {
		Player.spriteUp = spriteUp;
	}

	public static Sprite getSpriteDown() {
		return spriteDown;
	}

	public static void setSpriteDown(Sprite spriteDown) {
		Player.spriteDown = spriteDown;
	}

	public static Sprite getSpriteLeft() {
		return spriteLeft;
	}

	public static void setSpriteLeft(Sprite spriteLeft) {
		Player.spriteLeft = spriteLeft;
	}

	public static Sprite getSpriteRight() {
		return spriteRight;
	}

	public static void setSpriteRight(Sprite spriteRight) {
		Player.spriteRight = spriteRight;
	}

	public Player(int x, int y) {
		super(spriteDown, x, y);
	}

	public void updateSpritePlayer(char keyTyped) {
		switch (keyTyped) {
		case 'Z':
			this.setSprite(Player.spriteUp);
			try {
				spriteUp.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'Q':
			this.setSprite(Player.spriteLeft);
			try {
				spriteLeft.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'S':
			this.setSprite(Player.spriteDown);
			try {
				spriteDown.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 'D':
			this.setSprite(Player.spriteRight);
			try {
				spriteRight.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
