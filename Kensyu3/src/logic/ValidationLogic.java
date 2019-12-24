package logic;

public class ValidationLogic {

	private boolean validation = false;

	/** 引数なしコンストラクタ */
	public ValidationLogic(){};

	/**
	 * 入力された名前が不正でないか判断をする（1文字以上、20文字以下）
	 * @param name
	 * @return
	 */
	public boolean nameVal(String name){
		name = strTrim(name);
		if(name.length() != 0 && name.length() <= 20){
			validation = true;
		}
		return validation;
	}

	/**
	 * 文字列の空白取り除き
	 * @param str
	 * @return
	 */
	private String strTrim(String str){
		str = str.trim();
		str = str.replace("　", "");
		return str;
	}
}
