package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

import entity.Entity;

class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	/** A simple Image **/
	Image Contour;
	
	/** A simple Image **/
	Image LittleDiamond;
	
	/** A simple Image **/
	Image Clock;

	/** A simple boolean **/
	boolean isWin = true;
	
	//Instanciates ViewPanel
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	//Get the ViewFrame
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	//Set the ViewFrame
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	//Update method
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	//Method to load Image
	public Image readImageContour() {
        try {
            this.Contour = ImageIO.read(new File("sprite/Contour.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.Contour;
    }
	
	//Method to load Image
    public Image readImageLittleDiamond() {
        try {
            this.LittleDiamond = ImageIO.read(new File("sprite/LittleDiamond.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.LittleDiamond;
    }
    
    //Method to load Image
    public Image readImageClock() {
        try {
            this.Clock = ImageIO.read(new File("sprite/Clock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.Clock;
    }
	
    //Method to draw the Panel
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.readImageContour();
		this.readImageLittleDiamond();
		this.readImageClock();
        Entity[][] entity = viewFrame.getModel().getMap().getEntityMap();
        this.viewFrame.getModel().loop();
        for(int x = 0; x <this.viewFrame.getModel().getMap().getWidthMap(); x++) {
            for(int y=0; y < this.viewFrame.getModel().getMap().getHeightMap(); y++) {
                if (entity[x][y] != null) {
                	graphics.drawImage(entity[x][y].getSprite().getImage(), x*40, 45 + y*40, this);      
				}               
            }
        }
        graphics.drawImage(this.Contour, 500, 0, this);
        graphics.drawImage(this.Contour, 950, 0, this);
        graphics.drawImage(this.LittleDiamond, 525, 10, this);
        graphics.drawImage(this.Clock, 965, 10, this);
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 18));
        graphics.drawString(": " + String.valueOf(this.viewFrame.getModel().getMap().getCount()), 550, 28);
        graphics.drawString(": " + String.valueOf(this.viewFrame.getModel().getMap().getCountdown()-this.viewFrame.getModel().getTimeSinceStart()/1000), 995, 28);
        if (this.viewFrame.getModel().getIsTime()) {
        	if(isWin) {
        		this.isWin = false;
        		this.viewFrame.printMessage(this.viewFrame.getModel().getLostMessage());
        	}	
		}
        if (this.viewFrame.getModel().isWin()) {
        	if(isWin) {
        		this.isWin = false;
        		this.viewFrame.printMessage(this.viewFrame.getModel().getWinMessage());
        	}
		}
        
	}
}
