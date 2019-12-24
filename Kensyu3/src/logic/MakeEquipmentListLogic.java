package logic;

import java.util.ArrayList;
import java.util.List;

import beans.AllyBean;
import beans.EquipmentBean;

/**
 * 装備アイテムのリスト作成ロジック
 * @author Yamada
 */
public class MakeEquipmentListLogic {

	public MakeEquipmentListLogic() {}

	/** 全ての装備リスト */
	public static List<EquipmentBean> makeList() {
		List<EquipmentBean> list = new ArrayList<EquipmentBean>();
		// DBにしたーい
		list.add(new EquipmentBean("A01", "丈夫な木の枝", 3, 0, 0, 0, 10));
		list.add(new EquipmentBean("A02", "フライパン", 5, 0, 0, 0, 15));
		list.add(new EquipmentBean("A03", "竹の槍", 6, 0, 0, 0, 20));
		list.add(new EquipmentBean("AA1", "方天画戟", 860, 50, 0, 50, 500000));
		list.add(new EquipmentBean("AA2", "青龍偃月刀", 750, 100, 0, 0, 450000));
		list.add(new EquipmentBean("B01", "皮の靴", 0, 2, 0, 2, 10));
		list.add(new EquipmentBean("B02", "普通の手袋", 0, 3, 0, 0, 15));
		list.add(new EquipmentBean("B03", "石の盾", 0, 6, 0, 0, 20));
		list.add(new EquipmentBean("BB1", "藤甲の鎧", 0, 300, 0, 50, 400000));
		list.add(new EquipmentBean("C01", "ボロボロの杖", 0, 0, 2, 0, 10));
		list.add(new EquipmentBean("C02", "欠けた水晶玉", 0, 0, 3, 0, 15));
		list.add(new EquipmentBean("C03", "ひのきの杖", 0, 0, 5, 0, 20));
		list.add(new EquipmentBean("CC1", "白羽扇", 0, 0, 550, 0, 450000));
		list.add(new EquipmentBean("FDR", "不思議なチカラ", 1000, 1000, 1000, 1000, 99999));

		return list;

	}

	/** 売り物 */
	public static List<EquipmentBean> makeGoodsList() {
		List<EquipmentBean> list = new ArrayList<EquipmentBean>();
		// DBにしたーい
		list.add(new EquipmentBean("A01", "丈夫な木の枝", 3, 0, 0, 0, 10));
		list.add(new EquipmentBean("A02", "フライパン", 5, 0, 0, 0, 15));
		list.add(new EquipmentBean("A03", "竹の槍", 6, 0, 0, 0, 20));
		list.add(new EquipmentBean("B01", "皮の靴", 0, 2, 0, 2, 10));
		list.add(new EquipmentBean("B02", "普通の手袋", 0, 3, 0, 0, 15));
		list.add(new EquipmentBean("B03", "石の盾", 0, 6, 0, 0, 20));
		list.add(new EquipmentBean("C01", "ボロボロの杖", 0, 0, 2, 0, 10));
		list.add(new EquipmentBean("C02", "欠けた水晶玉", 0, 0, 3, 0, 15));
		list.add(new EquipmentBean("C03", "ひのきの杖", 0, 0, 5, 0, 20));

		return list;

	}

	/**
	 * 装備中フラグ付き所持品一覧の作成
	 * @param main AllyBean
	 * @return 装備中フラグ付き所持品一覧
	 */
	public static List<EquipmentBean> makeHaveList(AllyBean main) {
		if (main.getEquipList() == null || main.getEquipList().size() == 0) {
			return main.getEquipList();
		}

		int tmpListNum1 = -1;
		int tmpListNum2 = -1;
		List<EquipmentBean> list = main.getEquipList();
		int i = 0;

		// 装備1
		for (EquipmentBean e:list) {
			if (main.getEquipment1().equals(e.getId())) {
				e.setIng(true);
				tmpListNum1 = i; // tempに保管
				break; // 重複IDの可能性があるので1つ見つけた時点でbreak;
			}
			i++;
		}
		// 装備2
		i = 0; // 初期化
		for (EquipmentBean e:list) {
			if (tmpListNum1 == i) {
				i++;
				continue;
			}
			if (main.getEquipment2().equals(e.getId())) {
				e.setIng(true);
				tmpListNum2 = i;
				break;
			}
			i++;
		}
		// 装備していない所持品の装備フラグをfalseに
		i = 0; // 初期化
		for (EquipmentBean e:list) {
			if (tmpListNum1 == i || tmpListNum2 == i) {
				i++;
				continue;
			}
			e.setIng(false);
			i++;
		}
		return main.getEquipList();
	}
}
