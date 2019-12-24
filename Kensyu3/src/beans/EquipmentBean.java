package beans;


/**
 * 装備アイテム用Bean
 * @author Yamada
 */
public class EquipmentBean {

	private String id;
	private String name;
	private int attack;
	private int defense;
	private int intelligence;
	private int speed;
	private int price;
	private boolean ing; // 装備フラグ

	public EquipmentBean() {}

	/** 引数ありコンストラクタ */
	public EquipmentBean(String id,String name,int attack,int defense,
			int intelligence,int speed, int price) {
		this.id = id;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.intelligence = intelligence;
		this.speed = speed;
		this.price = price;
		this.ing = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isIng() {
		return ing;
	}

	public void setIng(boolean ing) {
		this.ing = ing;
	}

}