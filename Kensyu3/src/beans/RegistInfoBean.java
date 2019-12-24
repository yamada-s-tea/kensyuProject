package beans;

import java.io.Serializable;

public class RegistInfoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	// 変数宣言
	private String name; // 氏名
	private int age; // 年齢
	private boolean sex; // 性別
	private String adress; // 住所
	private String biko; // 備考

	// コンストラクタ
	public RegistInfoBean(){}

	// アクセサメソッド
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public boolean isSex() { return sex; }
	public void setSex(boolean sex) { this.sex = sex; }
	public String getAdress() { return adress; }
	public void setAdress(String adress) { this.adress = adress; }
	public String getBiko() { return biko; }
	public void setBiko(String biko) { this.biko = biko; };
}