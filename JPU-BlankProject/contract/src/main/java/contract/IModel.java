package contract;

import java.util.Observable;

import entity.Map;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	Map getMap();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 * @return 
	 */
	void loadMap(String code);
	
	void movePlayer(char c);
	
	void loop();
	
	//void checkGravity();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	String getWinMessage();
	
	String getLostTimeMessage();
	
	String getLostDeadMessage();
	
	boolean isWin();
	
	boolean getIsWin();
	
	boolean getIsAlive();
	
	void viewNotify();
	
	void setWin(boolean isWin);
	
	long getTimeSinceStart();
	
	boolean getIsTime();
}
