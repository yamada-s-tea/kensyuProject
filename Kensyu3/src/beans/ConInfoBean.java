package beans;

import java.io.Serializable;

public class ConInfoBean implements Serializable{
	private static final long serialVersionUID = 1L;

	// 変数宣言
	private String name; // 氏名
	private Integer age; // 年齢
	private String sex; // 性別
	private String adress; // 住所
	private String biko; // 備考

	/** 引数なしコンストラクタ */
	public ConInfoBean(){}

	// アクセサメソッド
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Integer getAge() { return age; }
	public void setAge(Integer age) { this.age = age; }
	public String getSex() { return sex; }
	public void setSex(String sex) { this.sex = sex; }
	public String getAdress() { return adress; }
	public void setAdress(String adress) { this.adress = adress; }
	public String getBiko() { return biko; }
	public void setBiko(String biko) { this.biko = biko; };
}