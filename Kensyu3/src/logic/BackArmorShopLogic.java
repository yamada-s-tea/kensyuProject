package logic;

import java.util.List;

import beans.AllyBean;
import beans.BattleBean;
import beans.EquipmentBean;

public class BackArmorShopLogic {

	public BackArmorShopLogic() {}

	/** 装備枠への付与(case文の練習みたいなの) */
	public void addEquip(AllyBean main, BattleBean battle, String id, int cnt) {

		switch (cnt) {
		case 0:
			main.setEquipment1(id);
			break; // switchは各caseに飛ばすだけでその後は普通に実行されてしまうので、breakが必須
		case 1:
			main.setEquipment2(id);
			break;
		default:
			System.out.println("BackArmorShopLogic：cntエラー");
			break;
		}
	}

	/** 装備確定処理 */
	public void confirmEquip(AllyBean main, BattleBean battle, int cnt) {
		switch (cnt) {
		// あえてbreak;を書かないで後続の処理実行を利用(フォールスロー)
		case 0:
			main.setEquipment1("");
		case 1:
			main.setEquipment2("");
		case 2:
			List<EquipmentBean> list = MakeEquipmentListLogic.makeList();
			changeStatus(main, list);
			MakeEquipmentListLogic.makeHaveList(main);
			break;
		}
	}

	/** 装備変更によるステータスの変更 */
	private void changeStatus(AllyBean main, List<EquipmentBean> list) {
		int a = 0;
		int b = 0;
		int c = 0;
		int s = 0;

		// 装備の追加
		if (main.getEquipment1() != null
				&& !main.getEquipment1().equals("")) {
			for (EquipmentBean li :list) {
				if (li.getId().equals(main.getEquipment1())) {
					a += li.getAttack();
					b += li.getDefense();
					c += li.getIntelligence();
					s += li.getSpeed();
				}
			}
		}
		if (main.getEquipment2() != null
				&& !main.getEquipment2().equals("")) {
			for (EquipmentBean li :list) {
				if (li.getId().equals(main.getEquipment2())) {
					a += li.getAttack();
					b += li.getDefense();
					c += li.getIntelligence();
					s += li.getSpeed();
				}
			}
		}

		// ステータスの合算
		main.setAttack(main.getOrgAttack() + a);
		main.setDefense(main.getOrgDefense() + b);
		main.setIntelligence(main.getOrgIntelligence() + c);
		main.setSpeed(main.getOrgSpeed() + s);

	}
}
