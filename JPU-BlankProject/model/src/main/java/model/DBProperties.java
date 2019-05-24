package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class DBProperties.
 *
 * @author Jean-Aymeric Diet
 */
class DBProperties extends Properties {

	/** The Constant serialVersionUID. */
	private static final long		serialVersionUID			= 5289057445894568927L;

	/** The Constant PROPERTIES_FILE_NAME. */
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";

	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/boulderdash?autoReconnect=true&useSSL=false";

	/** The login. */
	private String login = "root";

	/** The password. */
	private String password = "";
	
	//Instantiates a new DB properties.
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

	//Get the URL
	public String getUrl() {
		return this.url;
	}

	//Set the URL
	private void setUrl(final String url) {
		this.url = url;
	}

	//Get the login
	public String getLogin() {
		return this.login;
	}

	//Set the login
	private void setLogin(final String login) {
		this.login = login;
	}

	//Get the password
	public String getPassword() {
		return this.password;
	}

	//Set the password
	private void setPassword(final String password) {
		this.password = password;
	}

}
