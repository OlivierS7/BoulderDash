package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		//this.setSize(400 + this.getInsets().left + this.getInsets().right, 60 + this.getInsets().top + this.getInsets().bottom);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String loadMap() {
        String map = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\r\n" + 
                "WTTTTTTTTTTTTOTTTTTTTTOOTTTTTTTTTTTTTTOW\r\n" + 
                "WTTTTTTTDTTTOOOOOOTDTTTTTTOODTTTTTTTTOOW\r\n" + 
                "WTOPOTTTTTTTOTTTOTTTTTTTTTTOOOTTTDTTOOTW\r\n" + 
                "WTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTDTTOTTW\r\n" + 
                "WTTTOTTTTTTTTTTTDTTTOTTTTTTTTTTOTTTTOTTW\r\n" + 
                "WTOOOTTTTSOOTTTTTTTTOOOOTTTTTTTTTTTTTTTW\r\n" + 
                "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWTTTOTOTTTTW\r\n" + 
                "WOOOTOOTTTTTTTTTTTTTOOTTTTTTTTTTTTTOTTTW\r\n" + 
                "WOTTTTTOTOOTTTTTTTDOTTTTTTTTTTTTTTTTTTTW\r\n" + 
                "WTTTOTTTOOTTOTTTTTOTTTTTOTTTTDTTTTTTTTTW\r\n" + 
                "WTOOTTTDOTTTOTTTTTOTTTTTOTTOTOTTTTTTTTOW\r\n" + 
                "WTOTTTTTTTTTODTTTTTTTTTOTTTOTTTTTTOOTTOW\r\n" + 
                "WTOOTTTOTTTTTTTTTTTTTOOTTTTDTTTTTTOOTTTW\r\n" + 
                "WTTTDTTOWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\r\n" + 
                "WTTTTTTTTTTTTTTTTOTTTTTTTTTTTTTOOOTTTTTW\r\n" + 
                "WTTTTTTTTTTTTDOTTOTTTTTTOTTTDOOOTTTOTTXW\r\n" + 
                "WTTOTTTTTTOTTTOTTOOTTTTOOTTTDTTTTTTTTTTW\r\n" + 
                "WTTTOOOTTTTOTTOTTTDTTTTTTTTODTTTTTOOTTTW\r\n" + 
                "WTOTTODTTTTOTTTTTTTTTTTTTTTOTTTTTOTTTTOW\r\n" + 
                "WTTTTOTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTW\r\n" + 
                "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\r\n";
        return map;
    }

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}
}
