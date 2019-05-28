package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE = null;

	/** The connection. */
	private Connection connection;

	//Instantiates a new DB connection.
	private DBConnection() {
		this.open();
	}

	//Gets the single instance of DBConnection.
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	//Open the connection
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	//Get the connection
	public Connection getConnection() {
		return this.connection;
	}
}
