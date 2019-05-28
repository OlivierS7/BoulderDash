package MobileElement;

import java.io.IOException;

import entity.Sprite;

public class Player extends MobileElement {

	/** The sprites. */
	static Sprite spriteDown = new Sprite('P', "Rockford.png");
	static Sprite spriteUp = new Sprite('P', "Back_Rockford.png");
	static Sprite spriteLeft = new Sprite('P', "Left_Rockford.png");
	static Sprite spriteRight = new Sprite('P', "Right_Rockford.png");

	/** A boolean to check if the player is alive. */
	boolean isAlive = true;

	//A static bloc which automatically load the image
	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Getter of SpriteUp
	public static Sprite getSpriteUp() {
		return spriteUp;
	}
	
	//Setter of SpriteUp
	public static void setSpriteUp(Sprite spriteUp) {
		Player.spriteUp = spriteUp;
	}
	
	//Getter of SpriteDown
	public static Sprite getSpriteDown() {
		return spriteDown;
	}
	
	//Setter of SpriteDown
	public static void setSpriteDown(Sprite spriteDown) {
		Player.spriteDown = spriteDown;
	}
	
	//Getter of SpriteLeft
	public static Sprite getSpriteLeft() {
		return spriteLeft;
	}
	
	//Setter of SpriteLeft
	public static void setSpriteLeft(Sprite spriteLeft) {
		Player.spriteLeft = spriteLeft;
	}
	
	//Getter of SpriteRight
	public static Sprite getSpriteRight() {
		return spriteRight;
	}
	
	//Setter of SpriteRight
	public static void setSpriteRight(Sprite spriteRight) {
		Player.spriteRight = spriteRight;
	}

	//Instanciates a Player
	public Player(int x, int y) {
		super(spriteDown, x, y);
	}

	//Method used to update the sprite
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
	
	//Getter of isAlive
	public boolean isAlive() {
		return isAlive;
	}

	//Setter of isAlive
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
