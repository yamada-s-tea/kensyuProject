package logic;

import beans.EnemyBean;

public class GlasslandLogic extends PlaceLogic {

	public GlasslandLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to5();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if(i<4) {
			enemy = CELogic.createEnemy("Rat", 30, 15, 5, 2, 10, 5, false);
		} else {
			enemy = CELogic.createEnemy("Bird", 40, 18, 3, 10, 18, 10, false);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}

}
