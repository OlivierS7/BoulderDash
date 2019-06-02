package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Olivier
 *
 */
public class Sprite {

	private Image image;

	private String imageName;

	private char consoleImage;

	private boolean imageLoaded;

	/**
	 * @param character
	 * @param imageName
	 */
	public Sprite(final char character, final String imageName) {
		this.setConsoleImage(character);
		this.setImageName(imageName);
	}

	/**
	 * @return an Image
	 */
	public final Image getImage() {
		return this.image;
	}

	/**
	 * Method use to load an image
	 * @throws IOException
	 */
	public final void loadImage() throws IOException {
		this.setImage(ImageIO.read(new File("sprite/" + this.getImageName())));
	}

	/**
	 * @return Console Image Character
	 */
	public final char getConsoleImage() {
		return this.consoleImage;
	}

	/**
	 * @param image
	 */
	private void setImage(final Image image) {
		this.image = image;
	}

	/**
	 * @param consoleImage
	 */
	private void setConsoleImage(final char consoleImage) {
		this.consoleImage = consoleImage;
	}

	/**
	 * @return Image Name
	 */
	public final String getImageName() {
		return this.imageName;
	}

	/**
	 * @param imageName
	 */
	private void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return if the image is loaded or not
	 */
	public final boolean isImageLoaded() {
		return this.imageLoaded;
	}

	/**
	 * @param isImageLoaded
	 */
	public final void setImageLoaded(final boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}
}