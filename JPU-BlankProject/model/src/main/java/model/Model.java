package model;

import java.sql.SQLException;
import java.util.Observable;
import database.*;
import CollisionsHandler.CollisionsHandler;
import contract.IModel;
import entity.Map;

public final class Model extends Observable implements IModel {

	private Map map;

	boolean isWin = false;

	private CollisionsHandler collisionHandler;

	public Model() {
		this.map = new Map();
		this.collisionHandler = new CollisionsHandler(getMap());
	}

	public Map getMap() {
		return this.map;
	}

	private void setMap(final Map map) {
		this.map = map;
		this.collisionHandler = new CollisionsHandler(map);
		this.setChanged();
		this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}

	@Override
	public void loadMap(final String code) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

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

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public String getWinMessage() {
		return "Thanks you for playing at our game. We hope that you will come back soon ! =)\nRestart the game to play on another map !";
	}

	public String getLostTimeMessage() {
		return "Time run out... =(\nRestart the game to play on another map !";
	}

	public String getLostDeadMessage() {
		return "You're dead !!\n Restart the game to try again !";
	}

	public void loop() {
		while (true) {
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

	public boolean getIsAlive() {
		return this.getMap().isPlayerAlive();
	}

}
