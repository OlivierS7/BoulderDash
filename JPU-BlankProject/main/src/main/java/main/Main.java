package main;

import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {

    public static void main(final String[] args) {
    	//Instanciation of Model, View and Controller
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        //Set the controller to the view
        view.setController(controller);
        //Pop-up display
        controller.control();
        //Play method called which start a loop to check gravity
        controller.play();
    }
}