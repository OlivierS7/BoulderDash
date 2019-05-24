package model;

import java.sql.SQLException;
import java.util.Observable;

import collision.CollisionsHandler;
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
		this.collisionHandler = new CollisionsHandler(this);
	}

	//Get the map
	public Map getMap() {
		return this.map;
	}

	//Set the map
	private void setMap(final Map map) {
		this.map = map;
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
		this.setChanged();
		this.notifyObservers();
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

	//A simple loop to verify collision
	public void loop() {
		this.collisionHandler.checkGravity();
		this.viewNotify();
	}
	
	//Notify the view to update visual
	public void viewNotify() {
		this.setChanged();
		this.notifyObservers();
	}
	
	
	
}
