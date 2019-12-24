package logic;

import beans.EnemyBean;

public class CastleLogic extends PlaceLogic {

	public CastleLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to2();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if(i == 0){
			enemy = CELogic.createEnemy("King", 50000, 450, 700, 550, 5000, 8000, true);
		} else if(i == 1) {
			enemy = CELogic.createEnemy("Devil", 66666, 666, 666, 666, 6666, 6666, true);
		} else {
			enemy = CELogic.createEnemy("Lu Bu", 75000, 1000, 600, 700, 8000, 5000, true);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}
}