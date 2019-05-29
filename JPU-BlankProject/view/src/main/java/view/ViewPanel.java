package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import MobileElement.Player;
import entity.Entity;

class ViewPanel extends JPanel implements Observer {

	private ViewFrame viewFrame;

	private static final long serialVersionUID = -998294702363713521L;

	Image Contour;

	Image LittleDiamond;

	Image Clock;

	boolean isWin = true;

	double scale = 2;

	int pixelImage = 40;

	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	public Image readImageContour() {
		try {
			this.Contour = ImageIO.read(new File("sprite/Contour.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.Contour;
	}

	public Image readImageLittleDiamond() {
		try {
			this.LittleDiamond = ImageIO.read(new File("sprite/LittleDiamond.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.LittleDiamond;
	}

	public Image readImageClock() {
		try {
			this.Clock = ImageIO.read(new File("sprite/Clock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.Clock;
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		Player playerPos = this.viewFrame.getModel().getMap().getPlayer();
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		if (this.viewFrame.getModel().getMap().getPlayer() != null) {
			((Graphics2D) graphics).translate(-playerPos.getX() * scale * pixelImage + this.getWidth() / 2,
					(-playerPos.getY()) * scale * pixelImage + this.getHeight() / 2 - 160);
			((Graphics2D) graphics).scale(scale, scale);
		}
		this.readImageContour();
		this.readImageLittleDiamond();
		this.readImageClock();
		Entity[][] entity = viewFrame.getModel().getMap().getEntityMap();
		for (int x = 0; x < this.viewFrame.getModel().getMap().getWidthMap(); x++) {
			for (int y = 0; y < this.viewFrame.getModel().getMap().getHeightMap(); y++) {
				if (entity[x][y] != null) {
					graphics.drawImage(entity[x][y].getSprite().getImage(), x * pixelImage, 45 + y * pixelImage, this);
				}
			}
		}
		drawGraphics(graphics);
		verifyWinOrLose(graphics);
	}

	private void verifyWinOrLose(Graphics graphics) {
		Player playerPos = this.viewFrame.getModel().getMap().getPlayer();
		if (this.viewFrame.getModel().getIsTime()) {
			this.viewFrame.buildViewFrame(this.getViewFrame().getModel(), 1);
			this.viewFrame.revalidate();
			if (isWin) {
				this.isWin = false;
				this.viewFrame.printMessage(this.viewFrame.getModel().getLostTimeMessage());
			}
		}
		if (this.viewFrame.getModel().getIsWin()) {
			this.viewFrame.buildViewFrame(this.getViewFrame().getModel(), 2);
			this.viewFrame.revalidate();
			if (isWin) {
				this.isWin = false;
				this.viewFrame.printMessage(this.viewFrame.getModel().getWinMessage());
			}
		}
		if (playerPos != null) {
			if (!this.viewFrame.getModel().getIsAlive()) {
				this.viewFrame.buildViewFrame(this.getViewFrame().getModel(), 1);
				this.viewFrame.revalidate();
				if (isWin) {
					this.isWin = false;
					this.viewFrame.printMessage(this.viewFrame.getModel().getLostDeadMessage());
				}
			}
		}
	}

	public void drawGraphics(Graphics graphics) {
		Player playerPos = this.viewFrame.getModel().getMap().getPlayer();
		if (playerPos != null) {
			((Graphics2D) graphics).scale(1 / scale, 1 / scale);
			((Graphics2D) graphics).translate(+playerPos.getX() * scale * pixelImage - this.getWidth() / 2,
					(+playerPos.getY()) * scale * pixelImage - this.getHeight() / 2 + 160);
			graphics.drawImage(this.Contour, 0, 0, 200, 80, this);
			graphics.drawImage(this.Contour, 1395, 0, 200, 80, this);
			graphics.drawImage(this.LittleDiamond, 35, 20, 40, 40, this);
			graphics.drawImage(this.Clock, 1425, 20, 40, 40, this);
			graphics.setFont(new Font("SansSerif", Font.PLAIN, 42));
			graphics.drawString(": " + String.valueOf(this.viewFrame.getModel().getMap().getCount()), 85, 55);
			graphics.drawString(": " + String.valueOf(this.viewFrame.getModel().getMap().getCountdown()
					- this.viewFrame.getModel().getTimeSinceStart() / 1000), 1475, 55);
		}
	}
}
