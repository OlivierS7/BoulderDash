package model;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Entity;

abstract class DAOEntity<E extends Entity> {

	/** The connection. */
	private final Connection connection;

	//Instanciates a new DAOEntity
	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	//Get the connection
	protected Connection getConnection() {
		return this.connection;
	}

	//Method use to execute stored procedure
	public abstract E find(String code);

}
