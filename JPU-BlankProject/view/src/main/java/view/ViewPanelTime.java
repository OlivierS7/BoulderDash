package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewPanelTime extends JPanel implements Observer {

	private static final long serialVersionUID = 5784682934133773896L;

	private ViewFrame viewFrame;

	Image Lose;

	public ViewPanelTime(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	@SuppressWarnings("unused")
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(Observable o, Object arg) {
		this.repaint();
	}

	public Image readImageLose() {
		try {
			this.Lose = ImageIO.read(new File("sprite/Lose.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.Lose;
	}

	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		readImageLose();
		graphics.drawImage(this.Lose, -150, 0, this);
	}
}
