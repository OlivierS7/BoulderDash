package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * @author Olivier
 *
 */
public final class View implements IView, Runnable {

	private final ViewFrame viewFrame;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

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

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
