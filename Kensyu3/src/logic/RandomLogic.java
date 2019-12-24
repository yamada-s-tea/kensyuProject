package logic;

import java.security.SecureRandom;

public class RandomLogic {

	private SecureRandom secure = new SecureRandom();

	// 引数なしコンストラクタ
	public RandomLogic() {}

	/** aからzまでのランダムな小文字アルファベット1つを返す */
	public String random() {
		StringBuffer pass = new StringBuffer();
		// 使用文字の羅列
		String useChar = "abcdefghkmnpqrstuvwxyz";
		// 使用文字の文字数を最大としてランダムな数値を出し、その数値を添え字として文字を抽出
		// 抽出した文字を変数に格納（追加）
		pass.append(useChar.charAt(secure.nextInt(useChar.length())));
		return pass.toString();
	}

	/** 0から5までの数値をランダムで返す */
	public int random0to5(){
		return secure.nextInt(6);
	}

	/** 0から2までの数値をランダムで返す */
	public int random0to2(){
		return secure.nextInt(3);
	}

	public int random0to99() {
		return secure.nextInt(100);
	}


}