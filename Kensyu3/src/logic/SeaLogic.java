package logic;

import beans.EnemyBean;

public class SeaLogic extends PlaceLogic {

	public SeaLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to5();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if ( i < 3 ) {
			enemy = CELogic.createEnemy("Octopus", 80, 20, 10, 5, 25, 20, false);
		} else if ( i < 5 ) {
			enemy = CELogic.createEnemy("Shark", 150, 25, 20, 20, 50, 50, false);
		} else {
			enemy = CELogic.createEnemy("Pirates", 2500, 80, 80, 30, 1200, 800, false);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}
}