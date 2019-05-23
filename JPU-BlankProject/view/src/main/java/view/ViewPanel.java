package view;

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

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
//		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
//		graphics.drawString(this.getViewFrame().getModel().getMap().getContent(), 10, 20);
        Entity[][] entity = viewFrame.getModel().getMap().getEntityMap();
        for(int x = 0; x <this.viewFrame.getModel().getMap().getWidthMap(); x++) {
            for(int y=0; y < this.viewFrame.getModel().getMap().getHeightMap(); y++) {
                if (entity[x][y] != null) {
                	graphics.drawImage(entity[x][y].getSprite().getImage(), x*16, y*16, this);      
				}
                          
                
            }
            
            
        }

	}

	public void setOnTheMap(char finalCharMap, int x, int y) {
		//this.mapEntity[x][y] = finalCharMap;
	} 
}
