package MobileElement;

import java.io.IOException;

import entity.Sprite;

public class Ennemy extends MobileElement {
	
	/** The sprites. */
	static Sprite spriteDown = new Sprite('E', "Ennemy.png");
    static Sprite spriteUp = new Sprite('E', "Ennemy.png");
    static Sprite spriteRight = new Sprite('E', "Ennemy.png");
    static Sprite spriteLeft = new Sprite('E', "Ennemy.png");
    
    /** A boolean to check if the ennemy is alive. */
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
        Ennemy.spriteUp = spriteUp;
    }

    //Getter of SpriteDown
    public static Sprite getSpriteDown() {
        return spriteDown;
    }

    //Setter of SpriteDown
    public static void setSpriteDown(Sprite spriteDown) {
        Ennemy.spriteDown = spriteDown;
    }
    
    //Getter of isAlive
    public boolean isAlive() {
		return isAlive;
	}

    //Stter of isAlive
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	//Getter of SpriteRight
    public static Sprite getSpriteRight() {
        return spriteRight;
    }

    //Setter of SpriteRight
    public static void setSpriteRight(Sprite spriteRight) {
        Ennemy.spriteRight = spriteRight;
    }
    
    //Getter of SpriteLeft
    public static Sprite getSpriteLeft() {
        return spriteLeft;
    }

    //Setter of SpriteLeft
    public static void setSpriteLeft(Sprite spriteLeft) {
        Ennemy.spriteLeft = spriteLeft;
    }
    
    //Instanciates an Ennemy
    public Ennemy(int x, int y) {
        super(spriteDown, x, y);
    }
    
    //Method used to update Sprite
    public void updateSpriteEnnemy() {
        this.setSprite(Ennemy.spriteUp);
        try {
            spriteUp.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setSprite(Ennemy.spriteDown);
        try {
            spriteDown.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.setSprite(Ennemy.spriteRight);
        try {
            spriteRight.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.setSprite(Ennemy.spriteLeft);
        try {
            spriteLeft.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
    
}
