package logic;

import beans.EnemyBean;

public class SecludedCaveLogic  extends PlaceLogic {

	public SecludedCaveLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to2();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if (i == 0) {
			enemy = CELogic.createEnemy("Demon", 42000, 420, 280, 200, 2900, 3000, true);
		} else if (i == 1) {
			enemy = CELogic.createEnemy("Phoenix", 55000, 770, 500, 350, 4800, 6500, true);
		} else {
			enemy = CELogic.createEnemy("Uroboros", 80000, 650, 800, 300, 5200, 5000, true);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}

}
