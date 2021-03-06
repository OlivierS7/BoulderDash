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

/**
 * @author Olivier
 *
 */
public class ViewPanelWin extends JPanel implements Observer {

	private static final long serialVersionUID = 5784682934133773896L;

	private ViewFrame viewFrame;

	Image Win;

	/**
	 * @param viewFrame
	 */
	public ViewPanelWin(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * @return a ViewFrame
	 */
	@SuppressWarnings("unused")
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * @param viewFrame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(Observable o, Object arg) {
		this.repaint();
	}

	/**
	 * @return Image Win
	 */
	public Image readImageWin() {
		try {
			this.Win = ImageIO.read(new File("sprite/Win.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.Win;
	}

	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		readImageWin();
		this.setBackground(Color.BLACK);
		graphics.drawImage(this.Win, 500, 200, this);
	}
}
