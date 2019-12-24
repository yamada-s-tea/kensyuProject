package logic;

import beans.EnemyBean;

public class SecludedForestLogic extends PlaceLogic {

	public SecludedForestLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to2();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if (i == 0) {
			enemy = CELogic.createEnemy("T rex", 45000, 750, 250, 150, 5500, 5500, true);
		} else if (i == 1) {
			enemy = CELogic.createEnemy("Unicorn", 30000, 450, 550, 600, 5000, 9000, true);
		} else {
			enemy = CELogic.createEnemy("Forest Dragon", 50000, 900, 500, 120, 6000, 4500, true);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}
}
