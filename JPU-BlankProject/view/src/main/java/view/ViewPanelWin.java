package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewPanelWin extends JPanel implements Observer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5784682934133773896L;

	/** The view frame. */
	private ViewFrame viewFrame;

	/** A simple Image **/
	Image Win;

	// Instanciates ViewPanelWin
	public ViewPanelWin(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	// Get the ViewFrame
	@SuppressWarnings("unused")
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	// Set the ViewFrame
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	// Update method
	public void update(Observable o, Object arg) {
		this.repaint();
	}

	// Method to load Image
	public Image readImageLose() {
		try {
			this.Win = ImageIO.read(new File("sprite/Win.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.Win;
	}

	//Method to draw the Panel
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		readImageLose();
		this.setBackground(Color.BLACK);
		graphics.drawImage(this.Win, 500, 200, this);
	}
}
