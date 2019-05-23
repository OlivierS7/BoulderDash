package entity;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
public class Map extends Entity {

	/** The id. */
	private int	id;

	/** The key. */
	private String	key;

	/** The message. */
	private String	content;
	
	private Entity[][] mapEntity;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id
	 *          the id
	 * @param key
	 *          the key
	 * @param message
	 *          the message
	 */
	public Map(final int id, final String key, final String message) {
		this.setId(id);
		this.setKey(key);
		this.setContent(message);
		createMap();
	}

	private void createMap() {
		String[] map = this.getContent().split("\n");
	}

	/**
	 * Instantiates a new hello world.
	 */
	public Map() {
		this(0, "", "");
	}

	public Map(String content) {
		this.setContent(content);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *          the new key
	 */
	public void setKey(final String key) {
		this.key = key;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public void setContent(final String message) {
		this.content = message;
	}

}
