package database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Olivier
 *
 */
class DBProperties extends Properties {

	private static final long serialVersionUID = 5289057445894568927L;

	private final static String PROPERTIES_FILE_NAME = "model.properties";

	private String url = "jdbc:mysql://localhost:3306/boulderdash?autoReconnect=true&useSSL=false";

	private String login = "root";

	private String password = "";

	public DBProperties() {
		InputStream inputStream;
		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);
		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setUrl(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
		}
	}

	/**
	 * @return the Url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param url
	 */
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * @param login
	 */
	private void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 */
	private void setPassword(final String password) {
		this.password = password;
	}

}
