package contract;

import java.util.Observable;

import entity.Map;

public interface IModel {

	Map getMap();

	void loadMap(String code);

	void movePlayer(char c);

	void loop();

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
