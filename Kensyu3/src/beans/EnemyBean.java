package beans;

public class EnemyBean extends StatusBean {

	/** 引数なしコンストラクタ */
	public EnemyBean() {}

	/** ドロップ経験値 */
	private int dropExp;
	/** ドロップお金 */
	private int dropMoney;
	/** ステータス固定フラグ */
	private boolean stFlg;

	// アクセサメソッド
	public int getDropExp(){return dropExp;}
	public void setDropExp(int dropExp) {this.dropExp = dropExp;}
	public int getDropMoney() {return dropMoney;}
	public void setDropMoney(int dropMoney) {this.dropMoney = dropMoney;}
	public boolean isStFlg() {return stFlg;}
	public void setStFlg(boolean stFlg) {this.stFlg = stFlg;}
}
