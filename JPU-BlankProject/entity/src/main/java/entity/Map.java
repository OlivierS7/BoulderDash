package entity;

import java.util.ArrayList;

import MobileElement.Diamond;
import MobileElement.Ennemy;
import MobileElement.Player;
import MobileElement.Stone;
import MotionlessElement.Air;
import MotionlessElement.Dirt;
import MotionlessElement.Exit;
import MotionlessElement.Wall;

/**
 * @author Olivier
 *
 */
public class Map extends Entity implements Runnable {

	private int id;

	private String content;

	private Entity[][] mapEntity;

	private int count = 0;

	private int countdown;

	private long startTime;

	private boolean isWin;

	public Map(final int id, final String message) {
		super();
		this.setId(id);
		this.setContent(message);
		this.setCountdown(200);
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

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public Entity[][] getEntityMap() {
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
		if (count < 0) {
			try {
				throw new Exception("Diamond count must be positiv");
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		this.count = count;
	}

	public boolean isCollision(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Stone || playerPos[x][y] instanceof Wall || playerPos[x][y] instanceof Exit
				|| playerPos[x][y] instanceof Ennemy) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDiamond(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Diamond) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPlayerAlive() {
		return this.getPlayer().isAlive();
	}

	public boolean isWin(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Exit && getCount() >= 10) {
			this.setWin(true);
			return true;
		} else {
			return false;
		}
	}

	public boolean isTime() {
		if (getCountdown() * 1000 - getTimeSinceStart() < 0) {
			return true;
		}
		return false;
	}

	public boolean isStoneOnRight(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Stone && playerPos[x + 1][y] instanceof Air) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isStoneOnLeft(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Stone && playerPos[x - 1][y] instanceof Air) {
			return true;
		} else {
			return false;
		}
	}

	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}

	public int getCountdown() {
		return this.countdown;
	}

	public ArrayList<Ennemy> getEnnemy() {
		Entity[][] entity = this.getEntityMap();
		ArrayList<Ennemy> ennemy = new ArrayList<Ennemy>();
		for (int y = 0; y < getHeightMap(); y++) {
			for (int x = 0; x < getWidthMap(); x++) {
				if (entity[x][y] instanceof Ennemy) {
					ennemy.add((Ennemy) entity[x][y]);
				}
			}
		}
		return ennemy;
	}

	public void moveEnnemyUp(Ennemy e) {
		boolean collision = isEnnemyCollision(getEntityMap(), e.getX(), e.getY() - 1);
		boolean isEnnemyOnPlayer = isEnnemyOnPlayer(getEntityMap(), e.getX(), e.getY() - 1);
		e.updateSpriteEnnemy();
		if (!collision) {
			if (isEnnemyOnPlayer) {
				this.getPlayer().setAlive(false);
			} else {
				getEntityMap()[e.getX()][e.getY() - 1] = getEntityMap()[e.getX()][e.getY()];
				getEntityMap()[e.getX()][e.getY()] = new Air(e.getX(), e.getY());
				e.setY(e.getY() - 1);
			}
		}
	}

	public void moveEnnemyDown(Ennemy e) {
		boolean collision = isEnnemyCollision(getEntityMap(), e.getX(), e.getY() + 1);
		boolean isEnnemyOnPlayer = isEnnemyOnPlayer(getEntityMap(), e.getX(), e.getY() + 1);
		e.updateSpriteEnnemy();
		if (!collision) {
			if (isEnnemyOnPlayer) {
				this.getPlayer().setAlive(false);
			} else {
				getEntityMap()[e.getX()][e.getY() + 1] = getEntityMap()[e.getX()][e.getY()];
				getEntityMap()[e.getX()][e.getY()] = new Air(e.getX(), e.getY());
				e.setY(e.getY() + 1);
			}
		}
	}

	public void moveEnnemyRight(Ennemy e) {
		boolean collision = isEnnemyCollision(getEntityMap(), e.getX() + 1, e.getY());
		boolean isEnnemyOnPlayer = isEnnemyOnPlayer(getEntityMap(), e.getX() + 1, e.getY());
		e.updateSpriteEnnemy();
		if (!collision) {
			if (isEnnemyOnPlayer) {
				this.getPlayer().setAlive(false);
			} else {
				getEntityMap()[e.getX() + 1][e.getY()] = getEntityMap()[e.getX()][e.getY()];
				getEntityMap()[e.getX()][e.getY()] = new Air(e.getX(), e.getY());
				e.setX(e.getX() + 1);
			}
		}
	}

	public void moveEnnemyLeft(Ennemy e) {
		boolean collision = isEnnemyCollision(getEntityMap(), e.getX() - 1, e.getY());
		boolean isEnnemyOnPlayer = isEnnemyOnPlayer(getEntityMap(), e.getX() - 1, e.getY());
		e.updateSpriteEnnemy();
		if (!collision) {
			if (isEnnemyOnPlayer) {
				this.getPlayer().setAlive(false);
			} else {
				getEntityMap()[e.getX() - 1][e.getY()] = getEntityMap()[e.getX()][e.getY()];
				getEntityMap()[e.getX()][e.getY()] = new Air(e.getX(), e.getY());
				e.setX(e.getX() - 1);
			}
		}
	}

	public boolean isEnnemyCollision(Entity[][] EnnemyPos, int x, int y) {
		if (EnnemyPos[x][y] instanceof Stone || EnnemyPos[x][y] instanceof Dirt || EnnemyPos[x][y] instanceof Wall
				|| EnnemyPos[x][y] instanceof Diamond || EnnemyPos[x][y] instanceof Exit) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEnnemyOnPlayer(Entity[][] EnnemyPos, int x, int y) {
		if (EnnemyPos[x][y] instanceof Player) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void run() {
		Entity[][] entity = this.getEntityMap();
		for (int y = 0; y < getHeightMap(); y++) {
			for (int x = 0; x < getWidthMap(); x++) {
				if (entity[x][y] instanceof Ennemy) {
					Thread t = new Thread((Runnable) this.getEntityMap()[x][y]);
					t.start();
				}
			}
		}
	}

	public static int getRandom(int maximum, int minimum) {
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}

	public void moveEnnemy() {
		ArrayList<Ennemy> ennemy = getEnnemy();
		for (Ennemy e : ennemy) {
			int ranNb = getRandom(0, 4);
			switch (ranNb) {
			case 1:
				moveEnnemyUp(e);
				break;
			case 2:
				moveEnnemyDown(e);
				break;
			case 3:
				moveEnnemyRight(e);
				break;
			case 4:
				moveEnnemyLeft(e);
				break;
			}
		}
	}

	public boolean moveUp() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX(), getPlayer().getY() - 1);
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX(), getPlayer().getY() - 1);
		boolean isWin = isWin(getEntityMap(), getPlayer().getX(), getPlayer().getY() - 1);
		getPlayer().updateSpritePlayer('Z');
		if (!collision) {
			getEntityMap()[getPlayer().getX()][getPlayer().getY() - 1] = getEntityMap()[getPlayer().getX()][getPlayer()
					.getY()];
			getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(), getPlayer().getY());
			getPlayer().setY(getPlayer().getY() - 1);
			if (isDiamond) {
				setCount(getCount() + 1);
			}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),
						getPlayer().getY());
				return true;
			}
		}
		return false;

	}

	public boolean moveDown() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX(), getPlayer().getY() + 1);
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX(), getPlayer().getY() + 1);
		boolean isWin = isWin(getEntityMap(), getPlayer().getX(), getPlayer().getY() + 1);
		getPlayer().updateSpritePlayer('S');
		if (!collision) {
			getEntityMap()[getPlayer().getX()][getPlayer().getY() + 1] = getEntityMap()[getPlayer().getX()][getPlayer()
					.getY()];
			getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(), getPlayer().getY());
			getPlayer().setY(getPlayer().getY() + 1);
			if (isDiamond) {
				setCount(getCount() + 1);
			}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),
						getPlayer().getY());
				return true;
			}
		}
		return false;
	}

	public boolean moveLeft() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX() - 1, getPlayer().getY());
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX() - 1, getPlayer().getY());
		boolean isWin = isWin(getEntityMap(), getPlayer().getX() - 1, getPlayer().getY());
		boolean isStoneOnSide = isStoneOnLeft(getEntityMap(), getPlayer().getX() - 1, getPlayer().getY());
		getPlayer().updateSpritePlayer('Q');
		if (!collision) {
			getEntityMap()[getPlayer().getX() - 1][getPlayer().getY()] = getEntityMap()[getPlayer().getX()][getPlayer()
					.getY()];
			getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(), getPlayer().getY());
			getPlayer().setX(getPlayer().getX() - 1);
			if (isDiamond) {
				setCount(getCount() + 1);
			}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),
						getPlayer().getY());
				return true;
			}
			if (isStoneOnSide) {
				getEntityMap()[getPlayer().getX() - 2][getPlayer()
						.getY()] = getEntityMap()[getPlayer().getX() - 1][getPlayer().getY()];
				getEntityMap()[getPlayer().getX() - 1][getPlayer()
						.getY()] = getEntityMap()[getPlayer().getX()][getPlayer().getY()];
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(),
						getPlayer().getY());
				getPlayer().setX(getPlayer().getX() - 1);
			}
		}
		return false;
	}

	public boolean moveRight() {
		boolean collision = isCollision(getEntityMap(), getPlayer().getX() + 1, getPlayer().getY());
		boolean isDiamond = isDiamond(getEntityMap(), getPlayer().getX() + 1, getPlayer().getY());
		boolean isWin = isWin(getEntityMap(), getPlayer().getX() + 1, getPlayer().getY());
		boolean isStoneOnSide = isStoneOnRight(getEntityMap(), getPlayer().getX() + 1, getPlayer().getY());
		getPlayer().updateSpritePlayer('D');
		if (!collision) {
			getEntityMap()[getPlayer().getX() + 1][getPlayer().getY()] = getEntityMap()[getPlayer().getX()][getPlayer()
					.getY()];
			getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(), getPlayer().getY());
			getPlayer().setX(getPlayer().getX() + 1);
			if (isDiamond) {
				setCount(getCount() + 1);
				;
			}
		} else {
			if (isWin) {
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Player(getPlayer().getX(),
						getPlayer().getY());
				return true;
			}
			if (isStoneOnSide) {
				getEntityMap()[getPlayer().getX() + 2][getPlayer()
						.getY()] = getEntityMap()[getPlayer().getX() + 1][getPlayer().getY()];
				getEntityMap()[getPlayer().getX() + 1][getPlayer()
						.getY()] = getEntityMap()[getPlayer().getX()][getPlayer().getY()];
				getEntityMap()[getPlayer().getX()][getPlayer().getY()] = new Air(getPlayer().getX(),
						getPlayer().getY());
				getPlayer().setX(getPlayer().getX() + 1);
			}
		}
		return false;
	}

	public void createMap() {
		String map = this.getContent();
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
