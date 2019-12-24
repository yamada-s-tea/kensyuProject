package beans;

public abstract class StatusBean {
	/** 引数なしコンストラクタ */
	public StatusBean(){};

	private String name; // 名前
	private int maxHp; // 最大体力
	private int hp; // 体力
	private int attack; // 攻撃力
	private int defense; // 防御力
	private int speed; // 素早さ

	// アクセサメソッド
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getMaxHp() {return maxHp;}
	public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public int getAttack() {return attack;}
	public void setAttack(int attack) {this.attack = attack;}
	public int getDefense() {return defense;}
	public void setDefense(int defense) {this.defense = defense;}
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	}
