package logic;

import beans.EnemyBean;

public class TheHarunaLogic extends PlaceLogic {

	public TheHarunaLogic() {}

	public EnemyBean createEnemy(){

		CreateEnemyLogic CELogic = new CreateEnemyLogic();
		EnemyBean enemy = CELogic.createEnemy("Gunma", 351000, 1500, 900, 1500, 30000, 30000, true);
		WriteLogLogic.createEnemyLog(this.getClass().getName(), enemy);
		return enemy;

	}

}
