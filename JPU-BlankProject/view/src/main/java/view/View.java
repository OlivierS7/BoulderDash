package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	//Instanciates a view
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	//Method to return an order regarding key code
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.Map1;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.Map2;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.Map3;
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.Map4;
			case KeyEvent.VK_NUMPAD5:
				return ControllerOrder.Map5;
			case KeyEvent.VK_Z:
				return ControllerOrder.Z;
			case KeyEvent.VK_Q:
				return ControllerOrder.Q;
			case KeyEvent.VK_S:
				return ControllerOrder.S;
			case KeyEvent.VK_D:
				return ControllerOrder.D;
			default:
				return ControllerOrder.NULL;
		}
	}


	//Method to print a message in a Pop-up
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	//Method to display the frame
	public void run() {
		this.viewFrame.setVisible(true);
	}
	
	//Set the controller
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
