package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    /** The image. */
    private Image   image;

    /** The image name. */
    private String  imageName;

    /** The console image. */
    private char    consoleImage;

    /** The is image loaded. */
    private boolean imageLoaded;

    /**
     * Instantiates a new sprite.
     *
     * @param character
     *            the character
     * @param imageName
     *            the image name
     */
    public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }


    //Getter of the Image
    public final Image getImage() {
        return this.image;
    }

    //Method used to load the image
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("sprite/" + this.getImageName())));
    }

    //Getter of the console Image
    public final char getConsoleImage() {
        return this.consoleImage;
    }

 	//Setter of the Image
    private void setImage(final Image image) {
        this.image = image;
    }

    //Setter of the console Image
    private void setConsoleImage(final char consoleImage) {
        this.consoleImage = consoleImage;
    }

    //Get the image name
    public final String getImageName() {
        return this.imageName;
    }

    //Set the image name
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    //Check if Image is loaded
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

   //Setter of the boolean to be sure that the image is loaded
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}