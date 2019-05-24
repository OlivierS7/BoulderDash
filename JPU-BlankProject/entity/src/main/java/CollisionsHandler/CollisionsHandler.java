package CollisionsHandler;

import MobileElement.Diamond;
import MobileElement.Stone;
import MotionlessElement.Air;
import MotionlessElement.Exit;
import MotionlessElement.Wall;
import entity.Entity;
import entity.Map;

public class CollisionsHandler {
	
	Map map;
	//Instanciates a new CollisionsHandler
	public CollisionsHandler(Map map) {
		this.map = map;
	}
	
	//Method to check gravity
	public void checkGravity() {
		for (int j = this.map.getHeightMap()-1; j >= 0; j--) {
			for (int i = 0; i < this.map.getWidthMap(); i++) {
				if ((this.map.getEntityMap()[i][j] instanceof Stone || this.map.getEntityMap()[i][j] instanceof Diamond)
						&& this.map.getEntityMap()[i][j + 1] instanceof Air) {
					this.map.getEntityMap()[i][j + 1] = this.map.getEntityMap()[i][j];
					this.map.getEntityMap()[i][j] = new Air(i, j);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (this.map.getEntityMap()[i][j] instanceof Stone && this.map.getEntityMap()[i][j+1] instanceof Stone
                        && this.map.getEntityMap()[i-1][j] instanceof Air && this.map.getEntityMap()[i-1][j+1] instanceof Air ) {
                    
                    this.map.getEntityMap()[i-1][j+1] = this.map.getEntityMap()[i][j];
                    this.map.getEntityMap()[i][j] = new Air(i,j);
    
                } else if (this.map.getEntityMap()[i][j] instanceof Stone && this.map.getEntityMap()[i][j+1] instanceof Stone
                        && this.map.getEntityMap()[i+1][j] instanceof Air && this.map.getEntityMap()[i+1][j+1] instanceof Air ) {
                    
                    this.map.getEntityMap()[i+1][j+1] = this.map.getEntityMap()[i][j];
                    this.map.getEntityMap()[i][j] = new Air(i,j);
                }
			}
		}
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
		if (playerPos[x][y] instanceof Exit && this.map.getCount() >= 10) {
			return true;
		} else {
			return false;
		}
	}
}
