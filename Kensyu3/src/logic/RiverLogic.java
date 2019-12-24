package logic;

import beans.EnemyBean;

/**
 * 川
 * @author yamada
 */
public class RiverLogic extends PlaceLogic {

	public RiverLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to5();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if (i < 3) {
			enemy = CELogic.createEnemy("Crayfish", 45, 25, 20, 6, 20, 10, false);
		} else if (i < 5) {
			enemy = CELogic.createEnemy("The crocodile", 80, 35, 30, 4, 35, 15, false);
		} else {
			enemy = CELogic.createEnemy("Kappa", 2000, 30, 15, 10, 500, 500, true);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}
}