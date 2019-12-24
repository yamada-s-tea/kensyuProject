package logic;

import beans.AllyBean;
import beans.BattleBean;
import beans.EnemyBean;
import beans.LevelBean;

public class BattleLogic {

	public BattleLogic() {}

	RandomLogic random = new RandomLogic();

	/** 戦闘 */
	public void battle(AllyBean main, EnemyBean enemy, BattleBean battle) {
		battle.setBattleLog(""); // ログの初期化
		WriteLogLogic.battleLog1(main, enemy);

		if (main.getSpeed() >= enemy.getSpeed()) {
			// 味方の方が早い場合 または同じ場合
			MtoE(main, enemy, battle);
			if (enemy.getHp() <= 0) {
				contJudge(main, enemy, battle);
				WriteLogLogic.battleLog2(main, enemy, battle);
				return;
			}
			EtoM(main, enemy, battle);
		} else {
			// 敵の方が早い場合
			EtoM(main, enemy, battle);
			if (main.getHp() <= 0) {
				contJudge(main,enemy,battle);
				WriteLogLogic.battleLog2(main, enemy, battle);
				return;
			}
			MtoE(main,enemy,battle);
		}
		contJudge(main,enemy,battle);
		WriteLogLogic.battleLog2(main, enemy, battle);
	}

	/** 味方から敵への攻撃 */
	private void MtoE(AllyBean main, EnemyBean enemy, BattleBean battle) {
		if (avoid(enemy.getSpeed() - main.getSpeed())) {
			// 攻撃が当たらなかった時
			battle.setBattleLog(battle.getBattleLog() + main.getName() + "の攻撃<br>" +  enemy.getName() + "は攻撃を躱した<br>");
		} else {
			// 攻撃が当たった時
			int damage = (main.getAttack() - enemy.getDefense());
			if (damage <= 0) {
				damage = 0 + random.random0to2();
			} else if (damage > 2) {
				damage -= random.random0to2();
			}
			enemy.setHp(enemy.getHp() - damage);
			battle.setBattleLog(battle.getBattleLog() + main.getName() + "の攻撃<br>" +  enemy.getName() + "に" + damage + "のダメージ<br>");
		}
	}

	/** 敵から味方への攻撃 */
	private void EtoM(AllyBean main, EnemyBean enemy, BattleBean battle){
		if (avoid(main.getSpeed() - enemy.getSpeed())) {
			// 攻撃が当たらなかった時
			battle.setBattleLog(battle.getBattleLog() + enemy.getName() + "の攻撃<br>" +  main.getName() + "は攻撃を躱した<br>");
		} else {
			// 攻撃が当たった時
			int damage = (enemy.getAttack() - main.getDefense());
			if (damage <= 0) {
				damage = 0 + random.random0to2();
			} else if (damage > 2) {
				damage -= random.random0to2();
			}
			main.setHp(main.getHp() - damage);
			battle.setBattleLog(battle.getBattleLog() + enemy.getName() + "の攻撃<br>" +  main.getName() + "に" + damage + "のダメージ<br>");
		}
	}

	/** 続行フラグの判断
	 *  1:続行 2:敗北 3:勝利 */
	private void contJudge(AllyBean main, EnemyBean enemy, BattleBean battle) {
		if (main.getHp() <= 0) { // 敗北
			battle.setBattleLog(battle.getBattleLog() + main.getName() + "は倒れた<br>");
			battle.setContFlg(2);
		} else if (enemy.getHp() <= 0) { // 勝利
			battle.setBattleLog(battle.getBattleLog() + enemy.getName() + "は倒れた<br>");
			battle.setContFlg(3);
			battleResult(main, enemy, battle);
		} else { // 続行
			battle.setContFlg(1);
		}
	}

	/** 逃走 */
	public void escape(AllyBean main, EnemyBean enemy, BattleBean battle) {
		WriteLogLogic.battleLog1(main, enemy);

		if (main.getSpeed() >= enemy.getSpeed()) {
			// 味方の方が早い場合
			battle.setBattleLog("にげきれた");
			battle.setContFlg(4);
		} else {
			// 敵の方が早い場合
			int i = random.random0to5();
			if (i < 4) {
				battle.setBattleLog("にげきれた");
				battle.setContFlg(4);
				return;
			}
			battle.setBattleLog("にげきれなかった<br>まわりこまれてしまった");
			EtoM(main, enemy, battle);
			contJudge(main, enemy, battle);
		}
		WriteLogLogic.battleLog2(main, enemy, battle);
	}

	/** 躱す判定<br>
	 * true：躱す<br>
	 * false：当たる */
	private boolean avoid(int diff) {
		// 100以上の差は99として扱う
		if (diff >= 100) {
			diff = 99;
		}
		// 0から99の値をランダムに生成、差分以下の値なら躱す
		if (diff >= random.random0to99()) {
			return true;
		} else {
			return false;
		}
	}

	/** 戦闘結果の処理 */
	private void battleResult(AllyBean main,EnemyBean enemy,BattleBean battle){
		if(battle.getContFlg() == 3){
			main.setExperience(main.getExperience() + enemy.getDropExp());
			main.setMoney(main.getMoney() + enemy.getDropMoney());
			battle.setBattleLog(battle.getBattleLog() + enemy.getDropExp() +"経験値と" + enemy.getDropMoney() + "Gを獲得<br>");
			// レベルアップ
			if(main.getLevel() < LevelBean.getMaxLevel()){
				LevelUp(main,battle);
			}
		}
	}

	/** レベルアップの処理 */
	private void LevelUp(AllyBean main, BattleBean battle) {

		LevelBean level = new LevelBean();
		int beforeLevel = main.getLevel();

		while(main.getLevel() < LevelBean.getMaxLevel()) {
			if(main.getExperience() >= level.getLevelTable().get(main.getLevel() + 1)) {
				main.setLevel(main.getLevel() + 1); // レベルの変更(UP)
				statusUp(main); // ステータスの変動
			} else {
				break;
			}
		}
		if(main.getLevel() != beforeLevel) {
			battle.setBattleLog(battle.getBattleLog() + main.getName() + "はレベルが" + main.getLevel() + "に上がった<br>");
		}
	}

	/** レベルアップ時のステータス変動
	 * ただしレベルの操作は行わない */
	private void statusUp(AllyBean main) {

		int a = main.getAttack() - main.getOrgAttack();
		int c = main.getIntelligence() - main.getOrgIntelligence();
		int b = main.getDefense() - main.getOrgDefense();
		int s = main.getSpeed() - main.getOrgSpeed();

		if (main.getLevel() < 5) {

			main.setMaxHp(main.getMaxHp() + 10);
			main.setMaxMp(main.getMaxMp() + 10);
			main.setOrgAttack(main.getOrgAttack() + 2);
			main.setOrgDefense(main.getOrgDefense() + 2);
			main.setOrgIntelligence(main.getOrgIntelligence() + 2);
			main.setOrgSpeed(main.getOrgSpeed() + 1);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() == 5) {

			main.setMaxHp(main.getMaxHp() * 2);
			main.setMaxMp(main.getMaxMp() * 2);
			main.setOrgAttack(main.getOrgAttack() * 2);
			main.setOrgIntelligence(main.getOrgIntelligence() * 2);
			main.setOrgDefense(main.getOrgDefense() * 2);
			main.setOrgSpeed(main.getOrgSpeed() * 2);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() < 10) {

			main.setMaxHp(main.getMaxHp() + 15);
			main.setMaxMp(main.getMaxMp() + 15);
			main.setOrgAttack(main.getOrgAttack() + 4);
			main.setOrgIntelligence(main.getOrgIntelligence() + 4);
			main.setOrgDefense(main.getOrgDefense() + 4);
			main.setOrgSpeed(main.getOrgSpeed() + 1);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() == 10) {

			main.setMaxHp(main.getMaxHp() * 3);
			main.setMaxMp(main.getMaxMp() * 3);
			main.setOrgAttack(main.getOrgAttack() * 3);
			main.setOrgIntelligence(main.getOrgIntelligence() * 3);
			main.setOrgDefense(main.getOrgDefense() * 3);
			main.setOrgSpeed(main.getOrgSpeed() * 3);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() < 15) {

			main.setMaxHp(main.getMaxHp() + 15);
			main.setMaxMp(main.getMaxMp() + 15);
			main.setOrgAttack(main.getOrgAttack() + 4);
			main.setOrgIntelligence(main.getOrgIntelligence() + 4);
			main.setOrgDefense(main.getOrgDefense() + 4);
			main.setOrgSpeed(main.getOrgSpeed() + 1);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() == 15) {

			main.setMaxHp(main.getMaxHp() + 50);
			main.setMaxMp(main.getMaxMp() + 50);
			main.setOrgAttack(main.getOrgAttack() + 10);
			main.setOrgIntelligence(main.getOrgIntelligence() + 10);
			main.setOrgDefense(main.getOrgDefense() + 10);
			main.setOrgSpeed(main.getOrgSpeed() + 10);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() < 20) {

			main.setMaxHp(main.getMaxHp() + 15);
			main.setMaxMp(main.getMaxMp() + 15);
			main.setOrgAttack(main.getOrgAttack() + 4);
			main.setOrgIntelligence(main.getOrgIntelligence() + 4);
			main.setOrgDefense(main.getOrgDefense() + 4);
			main.setOrgSpeed(main.getOrgSpeed() + 1);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() == 20) {

			main.setMaxHp(main.getMaxHp() + 100);
			main.setMaxMp(main.getMaxMp() + 100);
			main.setOrgAttack(main.getOrgAttack() * 2);
			main.setOrgIntelligence(main.getOrgIntelligence() * 2);
			main.setOrgDefense(main.getOrgDefense() * 2);
			main.setOrgSpeed(main.getOrgSpeed() + 10);

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() < 30) {

			main.setMaxHp(main.getMaxHp() + 100 + random.random0to5());
			main.setMaxMp(main.getMaxMp() + 100 + random.random0to5());
			main.setOrgAttack(main.getOrgAttack() + 20 + random.random0to5());
			main.setOrgIntelligence(main.getOrgIntelligence() + 20 + random.random0to5());
			main.setOrgDefense(main.getOrgDefense() + 20 + random.random0to5());
			main.setOrgSpeed(main.getOrgSpeed() + 1 + random.random0to5());

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() == 30) {

			main.setMaxHp(main.getMaxHp() + 500 + random.random0to5());
			main.setMaxMp(main.getMaxMp() + 500 + random.random0to5());
			main.setOrgAttack(main.getOrgAttack() + 100 + random.random0to5());
			main.setOrgIntelligence(main.getOrgIntelligence() + 100 + random.random0to5());
			main.setOrgDefense(main.getOrgDefense() + 100 + random.random0to5());
			main.setOrgSpeed(main.getOrgSpeed() + 50 + random.random0to5());

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		} else if (main.getLevel() > 30) {

			main.setMaxHp(main.getMaxHp() + 200 + random.random0to5());
			main.setMaxMp(main.getMaxMp() + 200 + random.random0to5());
			main.setOrgAttack(main.getOrgAttack() + 60 + random.random0to5());
			main.setOrgIntelligence(main.getOrgIntelligence() + 60 + random.random0to5());
			main.setOrgDefense(main.getOrgDefense() + 60 + random.random0to5());
			main.setOrgSpeed(main.getOrgSpeed() + 5 + random.random0to5());

			main.setAttack(main.getOrgAttack() + a);
			main.setIntelligence(main.getOrgIntelligence() + c);
			main.setDefense(main.getOrgDefense() + b);
			main.setSpeed(main.getOrgSpeed() + s);

		}
	}
}
