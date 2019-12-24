package beans;

import java.io.Serializable;

public class BattleBean implements Serializable{
	private static final long serialVersionUID = 1L;

	public BattleBean() {
		this.battleLog = "";
		this.contFlg = 1;
	}

	/** バトルログ */
	private String battleLog;
	/** コンティニューフラグ */
	private int contFlg;
	/** 場所名 */
	private String place;

	// アクセサメソッド
	public String getBattleLog() {return battleLog;}
	public void setBattleLog(String battleLog) {this.battleLog = battleLog;}
	public int getContFlg() {return contFlg;}
	public void setContFlg(int contFlg) {this.contFlg = contFlg;}
	public String getPlace() {return place;}
	public void setPlace(String place) {this.place = place;}

}
