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
	
	private int count = 0;
	
	private int countdown;
	
	private long startTime;
	
	public Map(final int id,  final String message) {
		super();
		this.setId(id);
		this.setContent(message);
		this.setCountdown(5);
		startTime = System.currentTimeMillis();
		createMap();
	}

	public long getTimeSinceStart() {
        return System.currentTimeMillis() - this.startTime;
    }
	
	public Map() {
		this(1, "");
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
	
	public Player getPlayer() {
		Entity[][] entity = this.getEntityMap();
		for (int y = 0; y < getHeightMap(); y++) {
            for (int x = 0; x < getWidthMap(); x++) {
                if (entity[x][y] instanceof Player) {
                	return (Player) entity[x][y];
                }
            }
        }
		return null;
	}
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public boolean isCollision(Entity[][] playerPos, int x, int y) {
		if(playerPos[x][y] instanceof Stone || playerPos[x][y] instanceof Wall || playerPos[x][y] instanceof Exit) {
            return true; 
        } else {
            return false;
        }
	}
	
	public boolean isDiamond(Entity[][] playerPos, int x, int y) {
		if(playerPos[x][y] instanceof Diamond) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isWin(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Exit && getCount() >= 10) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTime() {
		if (getCountdown()*1000-getTimeSinceStart() < 0) {
			return true;
		}
		return false;
	}

    public void setCountdown(int countdown) {
		this.countdown = countdown;
	}


	public int getCountdown() {
        return this.countdown;
    }
	
	public boolean moveUp() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX(), getPlayer().getY()-1);
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX(), getPlayer().getY()-1);
		boolean isWin = isWin(getEntityMap(), getPlayer().getX(), getPlayer().getY()-1);
		getPlayer().updateSpritePlayer('Z');
		if (!collision) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()-1] = getEntityMap()[getPlayer().getX()][getPlayer().getY()];
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(),getPlayer().getY());
				getPlayer().setY(getPlayer().getY()-1);
				if (isDiamond) {
					setCount(getCount() + 1);
				}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),getPlayer().getY());
				return true;
			}
		}
		return false;
		
	}
	



	public boolean moveDown() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX(), getPlayer().getY()+1);
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX(), getPlayer().getY()+1);
		boolean isWin = isWin(getEntityMap(), getPlayer().getX(), getPlayer().getY()+1);
		getPlayer().updateSpritePlayer('S');
		if (!collision) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()+1] = getEntityMap()[getPlayer().getX()][getPlayer().getY()];
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(),getPlayer().getY());
				getPlayer().setY(getPlayer().getY()+1);
				if (isDiamond) {
					setCount(getCount() + 1);
				}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),getPlayer().getY());
				return true;
			}
		}
		return false;
	}
	
	public boolean moveLeft() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX()-1, getPlayer().getY());
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX()-1, getPlayer().getY());
		boolean isWin = isWin(getEntityMap(), getPlayer().getX()-1, getPlayer().getY());
		getPlayer().updateSpritePlayer('Q');
		if (!collision) {
				getEntityMap()[getPlayer().getX()-1][getPlayer().getY()] = getEntityMap()[getPlayer().getX()][getPlayer().getY()];
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(),getPlayer().getY());
				getPlayer().setX(getPlayer().getX()-1);
				if (isDiamond) {
					setCount(getCount() + 1);
				}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),getPlayer().getY());
				return true;
			}
		}
		return false;
	}
	
	public boolean moveRight() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX()+1, getPlayer().getY());
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX()+1, getPlayer().getY());
		boolean isWin = isWin(getEntityMap(), getPlayer().getX()+1, getPlayer().getY());
		getPlayer().updateSpritePlayer('D');
		if (!collision) {
				getEntityMap()[getPlayer().getX()+1][getPlayer().getY()] = getEntityMap()[getPlayer().getX()][getPlayer().getY()];
		        getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(),getPlayer().getY());
		        getPlayer().setX(getPlayer().getX()+1);
		        if (isDiamond) {
					setCount(getCount() + 1);;
				}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),getPlayer().getY());
				return true;
			}
		}
		return false;
	}
	
	public void createMap() {
		String map = this.getContent(); //Loading map in a string
		if (getHeightMap() >= 1 && getWidthMap() >= 1) {
			this.mapEntity = new Entity[this.getWidthMap()][this.getHeightMap()]; //Instanciate a two dimensional Array of Entity
			for (int y = 0; y < getHeightMap(); y++) {
				String[] finalMap = map.split("\n"); //Load each line of the map in an array of String
                for (int x = 0; x < getWidthMap(); x++) {
                	switch (finalMap[y].toCharArray()[x]) {
                	//Look Character and Load entity related to the character
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
