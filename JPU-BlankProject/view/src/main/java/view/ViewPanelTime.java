package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IModel;

public class ViewPanelTime extends JPanel implements Observer {
	private ViewFrame viewFrame;
	
	public ViewPanelTime(final ViewFrame viewFrame) {
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
		public void update(Observable o, Object arg) {
			this.repaint();
		}
		
		protected void paintComponent(final Graphics graphics) {
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			graphics.drawString("LOOSE NOOB", 200, 200);
		}
}

		
