package CollisionsHandler;

import MobileElement.Diamond;
import MobileElement.Ennemy;
import MobileElement.Player;
import MobileElement.Stone;
import MotionlessElement.Air;
import entity.Entity;
import entity.Map;

/**
 * @author Olivier
 *
 */
public class CollisionsHandler {

	private Map map;

	/**
	 * @param map
	 */
	public CollisionsHandler(Map map) {
		this.map = map;
	}

	/**
	 * Method use to check gravity
	 */
	public void checkGravity() {

		Entity[][] entity = this.map.getEntityMap();
		int height = this.map.getHeightMap();
		int width = this.map.getWidthMap();

		for (int j = height - 1; j >= 0; j--) {
			for (int i = 0; i < width; i++) {
				if ((entity[i][j] instanceof Stone || entity[i][j] instanceof Diamond)
						&& this.map.getEntityMap()[i][j + 1] instanceof Air) {
					if (entity[i][j] instanceof Stone) {
						((Stone) entity[i][j]).setFallen(true);
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
				} else if ((entity[i][j] instanceof Stone || entity[i][j] instanceof Diamond)
						&& this.map.getEntityMap()[i][j + 1] instanceof Ennemy) {
					if (entity[i][j] instanceof Stone) {
						if (((Stone) entity[i][j]).isFallen()) {
							this.map.getEnnemy().remove(entity[i][j + 1]);
							entity[i][j + 1] = new Air(i, j);
							entity[i + 1][j] = new Diamond(i + 1, j);
							entity[i - 1][j] = new Diamond(i - 1, j);
							entity[i][j + 1] = new Diamond(i, j + 1);
							entity[i][j - 1] = new Diamond(i, j - 1);
						}
					} else if (((Diamond) entity[i][j]).isFallen()) {
						this.map.getPlayer().setAlive(false);
					}
				} else if (entity[i][j] instanceof Stone && this.map.getEntityMap()[i][j + 1] instanceof Stone
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

				} else if (entity[i][j] instanceof Stone && this.map.getEntityMap()[i][j + 1] instanceof Stone
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
						((Diamond) entity[i][j]).setFallen(false);
						((Diamond) entity[i][j]).setFalling(0);
					}

				}
			}
		}
		this.map.UpdateDiamond();
	}
}
