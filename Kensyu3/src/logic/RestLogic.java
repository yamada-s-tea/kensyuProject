package logic;

import beans.AllyBean;
import beans.BattleBean;

public class RestLogic {

	public RestLogic() {}

	/** 小屋休憩処理 */
	public void rest(AllyBean main, BattleBean battle) {
		if (main.getMoney() < 20) {
			battle.setBattleLog("お金が足りません<br>");
		} else {
			WriteLogLogic.restLog1(main);

			int recHp = 0;
			int recMp = 0;

			if (main.getLevel() < 5) {
				recHp = 20;
				recMp = 10;
			} else {
				recHp = main.getMaxHp() / 4; // 小数点以下は自動切り捨て
				recMp = main.getMaxMp() / 4;
			}

			main.setMoney(main.getMoney() - 20);
			main.setHp(main.getHp() + recHp);
			if(main.getMaxHp() < main.getHp()) {
				main.setHp(main.getMaxHp()); // 最大値超過なら最大値まで
			}
			main.setMp(main.getMp() + recMp);
			if(main.getMaxMp() < main.getMp()) {
				main.setMp(main.getMaxMp());
			}
			/* 最大以上の回復かを先に考慮するパターン */
//			if(main.getMaxMp() - main.getMp() > recMp) {
//				main.setMp(main.getMaxMp());
//			} else {
//				main.setMp(main.getMp() + recMp);
//			}
			WriteLogLogic.restLog2(main, recHp, recMp);
			battle.setBattleLog("体力を少し回復した<br>");
		}
	}

	/** 宿の休み(全快)処理 */
	public void restAll(AllyBean main, BattleBean battle) {
		if (main.getMoney() < 100) {
			battle.setBattleLog("お金が足りません<br>");
		} else {
			WriteLogLogic.restLog1(main);

			main.setHp(main.getMaxHp());
			main.setMp(main.getMaxMp());
			main.setMoney(main.getMoney() - 100);

			WriteLogLogic.restLog2(main, main.getMaxHp(), main.getMaxMp());
			battle.setBattleLog("体力を全快した<br>");
		}
	}
}
