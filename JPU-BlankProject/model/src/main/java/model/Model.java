package model;

import java.sql.SQLException;
import java.util.Observable;
import database.*;
import CollisionsHandler.CollisionsHandler;
import contract.IModel;
import entity.Map;

public final class Model extends Observable implements IModel {

	/** The map. */
	private Map map;
	
	/** The boolean isWin. */
	boolean isWin = false;
	
	/** The CollisionsHandler. */
	private CollisionsHandler collisionHandler;
	
	
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

	//Getter boolean isWin
	public boolean isWin() {
		return isWin;
	}
	
	//Setter boolean isWin
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	//Getter WinMessage
	public String getWinMessage() {
		return "Thanks you for playing at our game. We hope that you will come back soon ! =)\nRestart the game to play on another map !";
	}
	
	//Getter LostTimeMessage
	public String getLostTimeMessage() {
		return "Time run out... =(\nRestart the game to play on another map !";
	}
	
	//Getter LostDeadMessage
	public String getLostDeadMessage() {
		return "You're dead !!\n Restart the game to try again !";
	}

	//A simple loop to verify collision
	public void loop() {
		while(true) {
			try {
				this.collisionHandler.checkGravity();
				if (this.map.getPlayer() != null) {
					this.map.moveEnnemy();
				}
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

	//Getter of time since start
	@Override
	public long getTimeSinceStart() {
		return this.getMap().getTimeSinceStart();
	}
	
	//Getter of boolean isTime
	public boolean getIsTime() {
		return this.getMap().isTime();
	}
	
	//Getter of boolean isWin
	public boolean getIsWin() {
		return this.getMap().isWin();
	}
	
	//Getter of boolean isAlive
	public boolean getIsAlive() {
		return this.getMap().isPlayerAlive();		
	}
	
}
