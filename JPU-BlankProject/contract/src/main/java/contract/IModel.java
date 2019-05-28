package contract;

import java.util.Observable;

import entity.Map;

public interface IModel {

	//Get the map
	Map getMap();

	//Load the mode 
	void loadMap(String code);
	
	//Move The Player
	void movePlayer(char c);
	
	//A simple loop to check the gravity 
	void loop();
	
	//Get the Observable
	Observable getObservable();
	
	//Get a win message
	String getWinMessage();
	
	//Get a lose time message
	String getLostTimeMessage();
	
	//Get a lose die message
	String getLostDeadMessage();
	
	//Method to check if we win
	boolean isWin();
	
	//Method to check if we win
	boolean getIsWin();
	
	//Method to check if we are alive
	boolean getIsAlive();
	
	//Method to notify the view
	void viewNotify();
	
	//Method to set win
	void setWin(boolean isWin);
	
	//Get the time since Start
	long getTimeSinceStart();
	
	//Method to check if timer isn't finish
	boolean getIsTime();
	
}
