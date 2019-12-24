package beans;

public enum EquipmentEnum {

	A01("ひのきの棒"),
	A02("フライパン"),
	A03("錆びた剣"); // 最後はコロン

	private String label; // フィールド定数

	private EquipmentEnum (String label) { // コンストラクタ
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
