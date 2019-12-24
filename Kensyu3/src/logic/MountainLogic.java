package logic;

import beans.EnemyBean;

public class MountainLogic extends PlaceLogic {

	public MountainLogic() {}

	public EnemyBean createEnemy(){

		EnemyBean enemy = new EnemyBean();
		RandomLogic random = new RandomLogic();
		int i = random.random0to5();

		CreateEnemyLogic CELogic = new CreateEnemyLogic();

		if( i < 2 ){
			enemy = CELogic.createEnemy("Bear", 450, 50, 40, 50, 120, 120, false);
		} else if( i < 4 ){
			enemy = CELogic.createEnemy("Thief", 300, 35, 20, 75, 50, 150, false);
		} else {
			enemy = CELogic.createEnemy("Dragon", 25000, 300, 240, 35, 2200, 1800, false);
		}

		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;
	}
}