package model;

import java.sql.SQLException;
import java.util.Observable;

import MotionlessElement.Air;
import contract.IModel;
import entity.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Map map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map();
	}

	/**
	 * Gets the hello world.
	 *
	 * @return the hello world
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the hello world.
	 *
	 * @param helloWorld the new hello world
	 */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
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
		switch (character) {
		case 'Z':
			this.map.moveUp();
            break;
		case 'Q':
			this.map.moveLeft();
			break;
		case 'S':
			this.map.moveDown();
			break;
		case 'D':
			this.map.moveRight();
			break;
		default:
			break;
		}
		 this.setChanged();
         this.notifyObservers();
	}

}
