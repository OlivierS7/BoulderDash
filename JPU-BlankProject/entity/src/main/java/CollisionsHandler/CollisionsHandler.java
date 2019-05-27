package CollisionsHandler;

import MobileElement.Diamond;
import MobileElement.Player;
import MobileElement.Stone;
import MotionlessElement.Air;
import MotionlessElement.Exit;
import MotionlessElement.Wall;
import entity.Entity;
import entity.Map;

public class CollisionsHandler {

	private Map map;

	// Instanciates a new CollisionsHandler
	public CollisionsHandler(Map map) {
		this.map = map;
	}

	// Method to check gravity
	public void checkGravity() {
		Entity[][] entity = this.map.getEntityMap();
		for (int j = this.map.getHeightMap() - 1; j >= 0; j--) {
			for (int i = 0; i < this.map.getWidthMap(); i++) {
				if ((entity[i][j] instanceof Stone || entity[i][j] instanceof Diamond)
						&& this.map.getEntityMap()[i][j + 1] instanceof Air) {
					if (entity[i][j] instanceof Stone) {
						((Stone) entity[i][j]).setFallen(true);
						System.out.println(((Stone) entity[i][j]).isFallen());
						((Stone) entity[i][j]).setFalling(((Stone) entity[i][j]).getFalling() + 1);
					} else if (entity[i][j] instanceof Diamond) {
						((Diamond) entity[i][j]).setFallen(true);
						((Diamond) entity[i][j]).setFalling(((Diamond) entity[i][j]).getFalling() + 1);
					}
					this.map.getEntityMap()[i][j + 1] = entity[i][j];
					entity[i][j] = new Air(i, j);
				} else if ((entity[i][j] instanceof Stone || entity[i][j] instanceof Diamond)
						&& this.map.getEntityMap()[i][j + 1] instanceof Player) {
					if (entity[i][j] instanceof Stone) {
						if (((Stone) entity[i][j]).isFallen()) {
							this.map.getPlayer().setAlive(false);
						}
					} else if (((Diamond) entity[i][j]).isFallen()) {
							this.map.getPlayer().setAlive(false);
						}
					} else if (entity[i][j] instanceof Stone
						&& this.map.getEntityMap()[i][j + 1] instanceof Stone
						&& this.map.getEntityMap()[i - 1][j] instanceof Air
						&& this.map.getEntityMap()[i - 1][j + 1] instanceof Air) {

					this.map.getEntityMap()[i - 1][j + 1] = entity[i][j];
					entity[i][j] = new Air(i, j);
					if (entity[i][j] instanceof Stone) {
						((Stone) entity[i][j]).setFallen(true);
						((Stone) entity[i][j]).setFalling(((Stone) entity[i][j]).getFalling() + 1);
					} else if (entity[i][j] instanceof Diamond) {
						((Diamond) entity[i][j]).setFallen(true);
						((Diamond) entity[i][j]).setFalling(((Diamond) entity[i][j]).getFalling() + 1);
					}
					
				} else if (entity[i][j] instanceof Stone
						&& this.map.getEntityMap()[i][j + 1] instanceof Stone
						&& this.map.getEntityMap()[i + 1][j] instanceof Air
						&& this.map.getEntityMap()[i + 1][j + 1] instanceof Air) {

					this.map.getEntityMap()[i + 1][j + 1] = entity[i][j];
					entity[i][j] = new Air(i, j);
					if (entity[i][j] instanceof Stone) {
						((Stone) entity[i][j]).setFallen(true);
						((Stone) entity[i][j]).setFalling(((Stone) entity[i][j]).getFalling() + 1);
					} else if (entity[i][j] instanceof Diamond) {
						((Diamond) entity[i][j]).setFallen(true);
						((Diamond) entity[i][j]).setFalling(((Diamond) entity[i][j]).getFalling() + 1);
					}
					
				} else {
					if (entity[i][j] instanceof Stone) {
						((Stone) entity[i][j]).setFallen(false);
						((Stone) entity[i][j]).setFalling(0);
					} else if (entity[i][j] instanceof Diamond) {
						((Diamond) entity[i][j]).setFallen(true);
						((Diamond) entity[i][j]).setFalling(0);
					}

				}
			}
		}
	}

	public boolean isCollision(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Stone || playerPos[x][y] instanceof Wall || playerPos[x][y] instanceof Exit) {
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

	public boolean isWin(Entity[][] playerPos, int x, int y) {
		if (playerPos[x][y] instanceof Exit && this.map.getCount() >= 10) {
			return true;
		} else {
			return false;
		}
	}
}
