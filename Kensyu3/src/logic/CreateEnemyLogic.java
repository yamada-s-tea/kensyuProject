package logic;

import beans.EnemyBean;

public class CreateEnemyLogic {

	public CreateEnemyLogic() {}

	public EnemyBean createEnemy(String name,int hp,int atk,int def,int spd,int exp,int money,boolean flg){

		if (flg) {
			EnemyBean enemy = new EnemyBean();
			enemy.setName(name);
			enemy.setMaxHp(hp);
			enemy.setHp(enemy.getMaxHp());
			enemy.setAttack(atk);
			enemy.setDefense(def);
			enemy.setSpeed(spd);
			enemy.setDropExp(exp);
			enemy.setDropMoney(money);

			return enemy;

		} else {
			RandomLogic ran = new RandomLogic();

			EnemyBean enemy = new EnemyBean();
			enemy.setName(name);
			enemy.setMaxHp(hp + ran.random0to5());
			enemy.setHp(enemy.getMaxHp());// 最大値をそのままセット
			enemy.setAttack(atk + ran.random0to5());
			enemy.setDefense(def + ran.random0to5());
			enemy.setSpeed(spd + ran.random0to5());
			enemy.setDropExp(exp + ran.random0to5());
			enemy.setDropMoney(money + ran.random0to5());

			return enemy;
		}
	}

}
