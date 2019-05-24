package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.Entity;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	Image[] image;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	
	public Image[] readImage() {
		this.image = new Image[2];
		try {
			this.image[0] = ImageIO.read(new File("sprite/Contour.png"));
			this.image[1] = ImageIO.read(new File("sprite/LittleDiamond.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.image;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.readImage();
        Entity[][] entity = viewFrame.getModel().getMap().getEntityMap();
        this.viewFrame.getModel().checkGravity();
        for(int x = 0; x <this.viewFrame.getModel().getMap().getWidthMap(); x++) {
            for(int y=0; y < this.viewFrame.getModel().getMap().getHeightMap(); y++) {
                if (entity[x][y] != null) {
                	graphics.drawImage(entity[x][y].getSprite().getImage(), x*40, 45 + y*40, this);      
				}               
            }
        }
        graphics.drawImage(this.image[0], 500, 0, this);
        graphics.drawImage(this.image[0], 950, 0, this);
        graphics.drawImage(this.image[1], 525, 10, this);
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 18));
        graphics.drawString(": " + String.valueOf(this.viewFrame.getModel().getMap().getCount()), 550, 28);
	}
}
