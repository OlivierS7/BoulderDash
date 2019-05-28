package contract;

public interface IController {

	//Method to display a message
	public void control();

	//Method use to do something for each types of order
	public void orderPerform(ControllerOrder controllerOrder);
}
