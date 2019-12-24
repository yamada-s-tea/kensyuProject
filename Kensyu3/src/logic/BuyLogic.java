package logic;

import java.util.List;

import beans.AllyBean;
import beans.BattleBean;
import beans.EquipmentBean;

public class BuyLogic {

	public BuyLogic() {}

	public void buy(AllyBean main, BattleBean battle, List<EquipmentBean> list, String id) {
		for (EquipmentBean li :list) {
			if (li.getId() == id) {
				if (li.getPrice() > main.getMoney()) {
					// 買えない場合
					battle.setBattleLog("お金が足りません。");
				} else {
					main.setMoney(main.getMoney() - li.getPrice()); // 会計
					main.getEquipList().add(li); // 所持に追加
					battle.setBattleLog(li.getName() + "を購入しました。"); // ログ
				}
			}
		}

	}
}
