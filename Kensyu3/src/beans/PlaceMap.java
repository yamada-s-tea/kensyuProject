package beans;

import java.io.Serializable;
import java.util.HashMap;

public class PlaceMap implements Serializable{
	private static final long serialVersionUID = 1L;

	private HashMap<String,String> placeMap = new HashMap<>();

	public PlaceMap() {
		placeMap.put("0","草原");
		placeMap.put("1","川");
		placeMap.put("2","海");
		placeMap.put("3","山");
		placeMap.put("4","城");
		placeMap.put("5","秘境(洞窟)");
		placeMap.put("6","秘境(密林)");
		placeMap.put("7","榛名湖");
		placeMap.put("8","武具屋へ(装備変更)");
		placeMap.put("9","小屋で休憩する(20G)");
		placeMap.put("10","宿で休む(100G)");
	}

	public HashMap<String,String> getPlaceMap() {return placeMap;}
	public void setPlaceMap(HashMap<String,String> placeMap) {this.placeMap = placeMap;};
}
