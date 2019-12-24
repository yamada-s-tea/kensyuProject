package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import logic.MakeEquipmentListLogic;

public class AllyBean extends StatusBean implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 引数なしコンストラクタ */
	public AllyBean() {}

	private int level; // レベル
	private int orgAttack; // 攻撃力(オリジナル)
	private int orgDefense; // 防御力(オリジナル)
	private int maxMp; // 最大魔力
	private int mp; // 魔力
	private int intelligence; // 知力
	private int orgIntelligence; // 知力(オリジナル)
	private int orgSpeed; // 素早さ(オリジナル)
	private int experience; // 経験値
	private int money; // お金
	private List<String> command = new ArrayList<String>();
	private List<EquipmentBean> equipList = new ArrayList<EquipmentBean>();
	private String equipment1;
	private String equipment2;

	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	public int getMaxMp() {return maxMp;}
	public void setMaxMp(int maxMp) {this.maxMp = maxMp;}
	public int getMp() {return mp;}
	public void setMp(int mp) {this.mp = mp;}
	public int getIntelligence() {return intelligence;}
	public void setIntelligence(int intelligence) {this.intelligence = intelligence;}
	public int getExperience() {return experience;}
	public void setExperience(int experience) {this.experience = experience;}
	public List<String> getCommand() {return command;}
	public void setCommand(List<String> command) {this.command = command;}
	public List<EquipmentBean> getEquipList() {return equipList;}
	public void setEquipList(List<EquipmentBean> equipList) {this.equipList = equipList;}
	public int getMoney() {return money;}
	public void setMoney(int money) {
		if(money > 999999999) {
			this.money = 999999999;
			return;
		}
		this.money = money;}
	public String getEquipment1() {return equipment1;}
	public void setEquipment1(String equipment1) {this.equipment1 = equipment1;}
	public String getEquipment2() {return equipment2;}
	public void setEquipment2(String equipment2) {this.equipment2 = equipment2;}

	/** 装備アイテム名称取得 */
	public String getEquipment1Name() {
		List<EquipmentBean> list = MakeEquipmentListLogic.makeList();
		for (EquipmentBean equip : list) {
			if(equip.getId().equals(equipment1) ) {
				return equip.getName();
			}
		}
		return "";
	}

	/** 装備アイテム名称取得 */
	public String getEquipment2Name() {
		List<EquipmentBean> list = MakeEquipmentListLogic.makeList();
		for (EquipmentBean equip : list) {
			if(equip.getId().equals(equipment2) ) {
				return equip.getName();
			}
		}
		return "";
	}
	public int getOrgAttack() {
		return orgAttack;
	}
	public void setOrgAttack(int orgAttack) {
		this.orgAttack = orgAttack;
	}
	public int getOrgDefense() {
		return orgDefense;
	}
	public void setOrgDefense(int orgDefense) {
		this.orgDefense = orgDefense;
	}
	public int getOrgIntelligence() {
		return orgIntelligence;
	}
	public void setOrgIntelligence(int orgIntelligence) {
		this.orgIntelligence = orgIntelligence;
	}
	public int getOrgSpeed() {
		return orgSpeed;
	}
	public void setOrgSpeed(int orgSpeed) {
		this.orgSpeed = orgSpeed;
	}
}
