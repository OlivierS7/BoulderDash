package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {

	private IView view;

	private IModel model;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	public void control() {
		this.view.printMessage("Welcome to our BoulderDash game !\n"
				+ "The game's protagonist is called Rockford and this is your character.\n"
				+ "You must dig through caves collecting diamonds (minimum 10) and reach the exit within a time limit,\n"
				+ "while avoiding various types of dangerous creatures as well as obstacles like falling rocks and the constant danger of being crushed or trapped by an avalanche. \n\n"
				+ "Please choose a map : 1, 2, 3, 4 or 5");
	}

	public void play() {
		this.model.loop();
	}

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case Map1:
			this.model.loadMap("1");
			break;
		case Map2:
			this.model.loadMap("2");
			break;
		case Map3:
			this.model.loadMap("3");
			break;
		case Map4:
			this.model.loadMap("4");
			break;
		case Map5:
			this.model.loadMap("5");
			break;
		case Z:
			this.model.movePlayer('Z');
			break;
		case Q:
			this.model.movePlayer('Q');
			break;
		case S:
			this.model.movePlayer('S');
			break;
		case D:
			this.model.movePlayer('D');
			break;
		default:
			break;
		}
	}

}
