package beans;

import java.io.Serializable;
import java.util.HashMap;

public class LevelBean implements Serializable{
	private static final long serialVersionUID = 1L;

	/** レベルテーブル（レベル,必要経験値） */
	private HashMap<Integer,Integer> levelTable;
	private final static int maxLevel = 50;

	public LevelBean() {
		levelTable = new HashMap<Integer,Integer>();
		levelTable.put(1,0);
		levelTable.put(2,50);
		levelTable.put(3,100);
		levelTable.put(4,200);
		levelTable.put(5,300);
		levelTable.put(6,450);
		levelTable.put(7,600);
		levelTable.put(8,800);
		levelTable.put(9,1000);
		levelTable.put(10,1200); // 10
		levelTable.put(11,1400);
		levelTable.put(12,1600);
		levelTable.put(13,1800);
		levelTable.put(14,2000);
		levelTable.put(15,2200);
		levelTable.put(16,2500);
		levelTable.put(17,2800);
		levelTable.put(18,3200);
		levelTable.put(19,3700);
		levelTable.put(20,4500); // 20
		levelTable.put(21,4500);
		levelTable.put(22,5000);
		levelTable.put(23,5500);
		levelTable.put(24,6000);
		levelTable.put(25,7000);
		levelTable.put(26,8000);
		levelTable.put(27,9000);
		levelTable.put(28,10000);
		levelTable.put(29,11000);
		levelTable.put(30,12000); // 30
		levelTable.put(31,13000);
		levelTable.put(32,14000);
		levelTable.put(33,15000);
		levelTable.put(34,16500);
		levelTable.put(35,18000);
		levelTable.put(36,20000);
		levelTable.put(37,22000);
		levelTable.put(38,24000);
		levelTable.put(39,26000);
		levelTable.put(40,28000); // 40
		levelTable.put(41,30000);
		levelTable.put(42,32000);
		levelTable.put(43,34000);
		levelTable.put(44,36000);
		levelTable.put(45,38000);
		levelTable.put(46,40000);
		levelTable.put(47,42000);
		levelTable.put(48,44000);
		levelTable.put(49,46000);
		levelTable.put(50,48000); // 50
	}

	// アクセサメソッド
	public HashMap<Integer, Integer> getLevelTable() {return levelTable;}
	public void setLevelTable(HashMap<Integer, Integer> levelTable) {this.levelTable = levelTable;}
	public static int getMaxLevel() {return maxLevel;}
}
