package MobileElement;

import java.io.IOException;

import entity.Sprite;

public class Ennemy extends MobileElement {
	
	static Sprite spriteDown = new Sprite('E', "Ennemy.png");
    static Sprite spriteUp = new Sprite('E', "Ennemy.png");
    static Sprite spriteRight = new Sprite('E', "Ennemy.png");
    static Sprite spriteLeft = new Sprite('E', "Ennemy.png");
    
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
        Ennemy.spriteUp = spriteUp;
    }

    public static Sprite getSpriteDown() {
        return spriteDown;
    }

    public static void setSpriteDown(Sprite spriteDown) {
        Ennemy.spriteDown = spriteDown;
    }
    
    public static Sprite getSpriteRight() {
        return spriteRight;
    }

    public static void setSpriteRight(Sprite spriteRight) {
        Ennemy.spriteRight = spriteRight;
    }
    
    public static Sprite getSpriteLeft() {
        return spriteLeft;
    }

    public static void setSpriteLeft(Sprite spriteLeft) {
        Ennemy.spriteLeft = spriteLeft;
    }
    
    
    public Ennemy(int x, int y) {
        super(spriteDown, x, y);
    }
    
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
