package collision;

import MobileElement.Diamond;
import MobileElement.Stone;
import MotionlessElement.Air;
import MotionlessElement.Exit;
import MotionlessElement.Wall;
import contract.IModel;
import entity.Entity;

public class CollisionsHandler {
	
	private IModel model;
	
	//Instanciates a new CollisionsHandler
	public CollisionsHandler(IModel model) {
		this.model = model;
	}
	
	//Method to check gravity
	public void checkGravity() {
		for (int j = model.getMap().getHeightMap()-1; j >= 0; j--) {
			for (int i = 0; i < model.getMap().getWidthMap(); i++) {
				if ((this.model.getMap().getEntityMap()[i][j] instanceof Stone || this.model.getMap().getEntityMap()[i][j] instanceof Diamond)
						&& this.model.getMap().getEntityMap()[i][j + 1] instanceof Air) {
					this.model.getMap().getEntityMap()[i][j + 1] = this.model.getMap().getEntityMap()[i][j];
					this.model.getMap().getEntityMap()[i][j] = new Air(i, j);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
