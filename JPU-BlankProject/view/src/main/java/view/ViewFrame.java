package view;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel model;

	/** The controller. */
	private IController	controller;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;

	//Instanciates a ViewFrame
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model, 0);
	}

	//Instanciates a ViewFrame
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model, 0);
	}

	//Instanciates a ViewFrame
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model, 0);
	}

	//Instanciates a ViewFrame
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model, 0);
	}

	//Get the Controller
	private IController getController() {
		return this.controller;
	}

	//Set the Controller
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	//Get the Model
	protected IModel getModel() {
		return this.model;
	}

	//Set the model
	private void setModel(final IModel model) {
		this.model = model;
	}

	//Build the ViewFrame
	public void buildViewFrame(final IModel model, int nb) {
		if (nb == 0) {
			this.setModel(model);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.addKeyListener(this);
			this.setContentPane(new ViewPanel(this));
			this.setSize(1600, 950);
			this.setTitle("BoulderDash");
			this.setLocationRelativeTo(null);
		} else if (nb == 1) {
			this.setModel(model);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.addKeyListener(this);
			this.setContentPane(new ViewPanelTime(this));
			this.setSize(1600, 950);
			this.setTitle("BoulderDash");
			this.setLocationRelativeTo(null);
			
		}
		
	}

	//Method to print message
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void keyTyped(final KeyEvent e) {
		
	}

	public void keyPressed(final KeyEvent e) {
		
	}

	public void keyReleased(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}
}
