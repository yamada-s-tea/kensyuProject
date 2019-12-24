package beans;

import java.io.Serializable;
import java.util.HashMap;

public class Adress1 implements Serializable{
	private static final long serialVersionUID = 1L;

	private HashMap<String,String> adress;

	public Adress1(){
	adress = new HashMap<String,String>();
	adress.put("1", "北海道");
	adress.put("2", "青森県");
	adress.put("3", "岩手県");
	adress.put("4", "宮城県");
	adress.put("5", "秋田県");
	adress.put("6", "山形県");
	adress.put("7", "福島県");
	adress.put("8", "茨城県");
	adress.put("9", "栃木県");
	adress.put("10", "群馬県");
	adress.put("11", "埼玉県");
	adress.put("12", "千葉県");
	adress.put("13", "東京都");
	adress.put("14", "神奈川県");
	adress.put("15", "新潟県");
	adress.put("16", "富山県");
	adress.put("17", "石川県");
	adress.put("18", "福井県");
	adress.put("19", "山梨県");
	adress.put("20", "長野県");
	adress.put("21", "岐阜県");
	adress.put("22", "静岡県");
	adress.put("23", "愛知県");
	adress.put("24", "三重県");
	adress.put("25", "滋賀県");
	adress.put("26", "京都府");
	adress.put("27", "大阪府");
	adress.put("28", "兵庫県");
	adress.put("29", "奈良県");
	adress.put("30", "和歌山県");
	adress.put("31", "鳥取県");
	adress.put("32", "島根県");
	adress.put("33", "岡山県");
	adress.put("34", "広島県");
	adress.put("35", "山口県");
	adress.put("36", "徳島県");
	adress.put("37", "香川県");
	adress.put("38", "愛媛県");
	adress.put("39", "高知県");
	adress.put("40", "福岡県");
	adress.put("41", "佐賀県");
	adress.put("42", "長崎県");
	adress.put("43", "熊本県");
	adress.put("44", "大分県");
	adress.put("45", "宮崎県");
	adress.put("46", "鹿児島県");
	adress.put("47", "沖縄県");
	}

	public HashMap<String, String> getAdress() {
		return adress;
	}

	public void setAdress(HashMap<String, String> adress) {
		this.adress = adress;
	}

	public String getAdress(int i){
		String key = String.valueOf(i);
		key = adress.get(key);
		return key;

	}
}
