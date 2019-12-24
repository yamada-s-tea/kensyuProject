package logic;

import beans.AllyBean;
import beans.BattleBean;
import beans.EnemyBean;

public class WriteLogLogic {

	public WriteLogLogic() {}

	/** 区切り行↓<br>
	 * ++++++++++++++++++++++++++++++ */
	private final static String line = "++++++++++++++++++++++++++++++";

	/** 敵生成時のログ */
	public static void createEnemyLog(String logicName, EnemyBean enemy) {
		System.out.println(line);
		System.out.println("敵を生成");
		System.out.println(line);
		System.out.println("クラス：" + logicName);
		System.out.println("名前：" + enemy.getName());
		System.out.println("HP：" + enemy.getHp() + "/" + enemy.getMaxHp());
		System.out.println("攻撃力：" + enemy.getAttack());
		System.out.println("防御力：" + enemy.getDefense());
		System.out.println("素早さ：" + enemy.getSpeed());
		System.out.println("ドロップ経験値：" + enemy.getDropExp());
		System.out.println("ドロップお金：" + enemy.getDropMoney());
		System.out.println(line);
	}

	/** 休みロジックの正常処理ログ1(金欠じゃない時) */
	public static void restLog1(AllyBean main) {
		System.out.println(line);
		System.out.println("休憩処理(前)");
		System.out.println(line);
		System.out.println("名前：" + main.getName());
		System.out.println("回復前HP：" + main.getHp() + "/" + main.getMaxHp());
		System.out.println("回復前MP：" + main.getMp() + "/" + main.getMaxMp());
		System.out.println("お金(支払い前):" + main.getMoney());
		System.out.println(line);
	}

	/** 休みロジックの正常処理ログ2(金欠じゃない時) */
	public static void restLog2(AllyBean main, int recHp, int recMp) {
		System.out.println(line);
		System.out.println("休憩処理(後)");
		System.out.println(line);
		System.out.println("名前：" + main.getName());
		System.out.println("回復後HP：" + main.getHp() + "/" + main.getMaxHp());
		System.out.println("回復後MP：" + main.getMp() + "/" + main.getMaxMp());
		System.out.println("HP回復量：" + recHp);
		System.out.println("MP回復量：" + recMp);
		System.out.println("お金(支払い後):" + main.getMoney());
		System.out.println(line);
	}

	/** 戦闘前ログ(ステータス) */
	public static void battleLog1(AllyBean main, EnemyBean enemy) {
		System.out.println(line);
		System.out.println("戦闘詳細(前)");
		System.out.println(line);
		System.out.println("詳細(味方)");
		System.out.println("名前：" + main.getName());
		System.out.println("HP：" + main.getHp() + "/" + main.getMaxHp());
		System.out.println("MP：" + main.getMp() + "/" + main.getMaxMp());
		System.out.println("攻撃力：" + main.getAttack());
		System.out.println("攻撃力(元)：" + main.getOrgAttack());
		System.out.println("知力：" + main.getIntelligence());
		System.out.println("知力(元)：" + main.getOrgIntelligence());
		System.out.println("防御力：" + main.getDefense());
		System.out.println("防御力(元)：" + main.getOrgDefense());
		System.out.println("素早さ：" + main.getSpeed());
		System.out.println("素早さ(元)：" + main.getOrgSpeed());
		System.out.println("");
		System.out.println("詳細(敵)");
		System.out.println("名前：" + enemy.getName());
		System.out.println("HP：" + enemy.getHp() + "/" + enemy.getMaxHp());
		System.out.println("攻撃力：" + enemy.getAttack());
		System.out.println("防御力：" + enemy.getDefense());
		System.out.println("素早さ：" + enemy.getSpeed());
		System.out.println("ドロップ経験値：" + enemy.getDropExp());
		System.out.println("ドロップお金：" + enemy.getDropMoney());
		System.out.println(line);
	}

	/** 戦闘後ログ(ステータス) */
	public static void battleLog2(AllyBean main, EnemyBean enemy, BattleBean battle) {
		System.out.println(line);
		System.out.println("戦闘詳細(後)");
		System.out.println(line);
		System.out.println("画面表示ログ");
		System.out.println(battle.getBattleLog());
		System.out.println("");
		System.out.println("詳細(味方)");
		System.out.println("名前：" + main.getName());
		System.out.println("HP：" + main.getHp() + "/" + main.getMaxHp());
		System.out.println("MP：" + main.getMp() + "/" + main.getMaxMp());
		System.out.println("攻撃力：" + main.getAttack());
		System.out.println("攻撃力(元)：" + main.getOrgAttack());
		System.out.println("知力：" + main.getIntelligence());
		System.out.println("知力(元)：" + main.getOrgIntelligence());
		System.out.println("防御力：" + main.getDefense());
		System.out.println("防御力(元)：" + main.getOrgDefense());
		System.out.println("素早さ：" + main.getSpeed());
		System.out.println("素早さ(元)：" + main.getOrgSpeed());
		System.out.println("");
		System.out.println("詳細(敵)");
		System.out.println("名前：" + enemy.getName());
		System.out.println("HP：" + enemy.getHp() + "/" + enemy.getMaxHp());
		System.out.println("攻撃力：" + enemy.getAttack());
		System.out.println("防御力：" + enemy.getDefense());
		System.out.println("素早さ：" + enemy.getSpeed());
		System.out.println("ドロップ経験値：" + enemy.getDropExp());
		System.out.println("ドロップお金：" + enemy.getDropMoney());
		System.out.println("");
		System.out.println("続行フラグ：" + battle.getContFlg());
		System.out.println(line);
	}
}
