package model;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Entity;

/**
 * @author Olivier
 *
 * @param <E>
 */
abstract class DAOEntity<E extends Entity> {

	private final Connection connection;

	/**
	 * @param connection
	 * @throws SQLException
	 */
	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * @return a connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

	public abstract E find(String code);

}
