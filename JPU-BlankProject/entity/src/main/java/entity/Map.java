package entity;

import MobileElement.Diamond;
import MobileElement.Ennemy;
import MobileElement.Player;
import MobileElement.Stone;
import MotionlessElement.Air;
import MotionlessElement.Dirt;
import MotionlessElement.Exit;
import MotionlessElement.Wall;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
public class Map extends Entity{

	/** The id. */
	private int	id;

	/** The message. */
	private String	content;
	
	private Entity[][] mapEntity;

	public Map(final int id,  final String message) {
		super();
		this.setId(id);
		this.setContent(message);
		createMap();
	}


	public Map() {
		this(1, "");
	}

	public Map(String content) {
		super();
		this.setContent(content);
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getWidthMap() {
		String[] map = this.getContent().split("\n");
		return map[0].length() - 1;
	}
	
	public int getHeightMap() {
		String[] map = this.getContent().split("\n");
		return map.length;
	}
	
	
	public String getContent() {
		return this.content;
	}

	public void setContent(final String message) {
		this.content = message;
	}
	
	public Entity[][] getEntityMap(){
		return this.mapEntity;
	}
	
	public void createMap() {
		String map = this.getContent();
		System.out.println(map);
		System.out.println(getHeightMap());
		System.out.println(getWidthMap());
		if (getHeightMap() >= 1 && getWidthMap() >= 1) {
			this.mapEntity = new Entity[this.getWidthMap()][this.getHeightMap()];
			for (int y = 0; y < getHeightMap(); y++) {
				String[] finalMap = map.split("\n");
                for (int x = 0; x < getWidthMap(); x++) {
                	switch (finalMap[y].toCharArray()[x]) {
					case 'W':
						mapEntity[x][y] = new Wall(x, y);
						break;
					case 'T':
						mapEntity[x][y] = new Dirt(x, y);
						break;
					case 'P':
						mapEntity[x][y] = new Player(x, y);
						break;
					case 'O':
						mapEntity[x][y] = new Stone(x, y);
						break;
					case 'E':
						mapEntity[x][y] = new Ennemy(x, y);
						break;
					case 'A':
						mapEntity[x][y] = new Air(x, y);
						break;
					case 'D':
						mapEntity[x][y] = new Diamond(x, y);
						break;
					case 'X':
						mapEntity[x][y] = new Exit(x, y);
						break;
					default:
						break;
					}
                }
            }
		}
	}
}
