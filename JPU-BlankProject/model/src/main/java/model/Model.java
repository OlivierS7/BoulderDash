package model;

import java.sql.SQLException;
import java.util.Observable;
import database.*;
import CollisionsHandler.CollisionsHandler;
import contract.IModel;
import entity.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private Map map;
	boolean isWin = false;
	CollisionsHandler collisionHandler;
	
	
	//Constructor of model
	public Model() {
		this.map = new Map();
		this.collisionHandler = new CollisionsHandler(getMap());
	}
	
	//Get the map
	public Map getMap() {
		return this.map;
	}

	//Set the map
	private void setMap(final Map map) {
		this.map = map;
		this.collisionHandler = new CollisionsHandler(map);
		this.setChanged();
		this.notifyObservers();
	}

	//Get the observable
	public Observable getObservable() {
		return this;
	}

	//Load the map
	@Override
	public void loadMap(final String code) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//Move the Player
	public void movePlayer(char character) {
		if (this.map.isPlayerAlive()) {
			switch (character) {
			case 'Z':
				this.isWin = this.map.moveUp();
				break;
			case 'Q':
				this.isWin = this.map.moveLeft();
				break;
			case 'S':
				this.isWin = this.map.moveDown();
				break;
			case 'D':
				this.isWin = this.map.moveRight();
				break;
			default:
				break;
			}
			this.viewNotify();
		}
		
	}

	//Get boolean isWin
	public boolean isWin() {
		return isWin;
	}
	//Set boolean isWin
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	//Get WinMessage
	public String getWinMessage() {
		return "Thanks you for playing at our game. We hope that you will come back soon ! =)\nRestart the game to play on another map !";
	}
	
	public String getLostMessage() {
		return "Time run out... =(\nRestart the game to play on another map !";
	}

	//A simple loop to verify collision
	public void loop() {
		while(true) {
			try {
				this.collisionHandler.checkGravity();
				this.viewNotify();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	//Notify the view to update visual
	public void viewNotify() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public long getTimeSinceStart() {
		return this.getMap().getTimeSinceStart();
	}
	
	public boolean getIsTime() {
		return this.getMap().isTime();
	}
	
	public boolean getIsWin() {
		return this.getMap().isWin();
	}
	
}
