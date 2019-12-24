package logic;

import java.util.ArrayList;

import beans.AllyBean;
import beans.EquipmentBean;

/**
 * 味方のパラメータ生成ロジック
 */
public class CreateAllyLogic {

	public CreateAllyLogic() {}

	public AllyBean createMainChar(String name,String attack,String way){
		AllyBean main = new AllyBean();
		if(name.length() > 6) { // 6文字以上は切り捨て
			name = name.substring(0, 6);
		}
		setOrigin(main,name);
		if(attack.equals("1")){
			// 腕力
			main.setMaxHp(30);
			main.setHp(main.getMaxHp());
			main.setAttack(15);
			main.setMaxMp(5);
			main.setMp(main.getMaxMp());
			main.setIntelligence(5);
		} else {
			// 知力
			main.setMaxHp(20);
			main.setHp(main.getMaxHp());
			main.setAttack(5);
			main.setMaxMp(20);
			main.setMp(main.getMaxMp());
			main.setIntelligence(20);
		}

		if(way.equals("1")){
			// 防御
			main.setDefense(25);
			main.setSpeed(10);
		} else {
			// 躱す
			main.setDefense(10);
			main.setSpeed(25);
		}

		if (main.getName().equals("Foudre")) {
			setSp(main);
		}

		if (main.getName().equals("Level")) {
			setSp2(main);
		}

		// オリジナル値にコピー
		main.setOrgAttack(main.getAttack());
		main.setOrgDefense(main.getDefense());
		main.setOrgIntelligence(main.getIntelligence());
		main.setOrgSpeed(main.getSpeed());

		return main;
	}

	/** 名前、レベル、経験値の初期値セット */
	private void setOrigin(AllyBean ally,String name){
		ally.setName(name);
		ally.setLevel(1);
		ally.setExperience(0);
		ally.setEquipment1("");
		ally.setEquipment2("");
		ally.setEquipList(new ArrayList<EquipmentBean>());
		ally.getEquipList().add(new EquipmentBean("A01", "丈夫な木の枝", 3, 0, 0, 0, 10));
		ally.getEquipList().add(new EquipmentBean("B01", "皮の靴", 0, 2, 0, 2, 10));
		ally.getEquipList().add(new EquipmentBean("C02", "欠けた水晶玉", 0, 0, 3, 0, 15));
	}

	private void setSp(AllyBean ally) {
		ally.setName("Foudre");
		ally.setLevel(1);
		ally.setExperience(0);

		ally.setMaxHp(5000);
		ally.setHp(ally.getMaxHp());
		ally.setAttack(500);
		ally.setMaxMp(5000);
		ally.setMp(ally.getMaxMp());
		ally.setIntelligence(500);
		ally.setDefense(500);
		ally.setSpeed(200);

		ally.setEquipment1("");
		ally.setEquipment2("");
		ally.setEquipList(new ArrayList<EquipmentBean>());
		ally.getEquipList().add(new EquipmentBean("FDR", "不思議なチカラ", 1000, 1000, 1000, 1000, 99999));
		ally.getEquipList().add(new EquipmentBean("FDR", "不思議なチカラ", 1000, 1000, 1000, 1000, 99999));
	}

	private void setSp2(AllyBean ally) {
		ally.setName("Level");
		ally.setLevel(1);
		ally.setExperience(48000);

		ally.setMaxHp(30);
		ally.setHp(ally.getMaxHp());
		ally.setAttack(15);
		ally.setMaxMp(5);
		ally.setMp(ally.getMaxMp());
		ally.setIntelligence(5);
		ally.setDefense(25);
		ally.setSpeed(10);

		ally.setEquipment1("");
		ally.setEquipment2("");
		ally.setEquipList(new ArrayList<EquipmentBean>());
	}

}
