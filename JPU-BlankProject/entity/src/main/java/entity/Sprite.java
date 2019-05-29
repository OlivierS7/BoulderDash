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

	public Sprite(final char character, final String imageName) {
		this.setConsoleImage(character);
		this.setImageName(imageName);
	}

	public final Image getImage() {
		return this.image;
	}

	public final void loadImage() throws IOException {
		this.setImage(ImageIO.read(new File("sprite/" + this.getImageName())));
	}

	public final char getConsoleImage() {
		return this.consoleImage;
	}

	private void setImage(final Image image) {
		this.image = image;
	}

	private void setConsoleImage(final char consoleImage) {
		this.consoleImage = consoleImage;
	}

	public final String getImageName() {
		return this.imageName;
	}

	private void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	public final boolean isImageLoaded() {
		return this.imageLoaded;
	}

	public final void setImageLoaded(final boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}
}