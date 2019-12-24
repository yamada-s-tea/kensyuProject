package logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import beans.Result;

public class RouletteLogic {

	/** 引数なしコンストラクタ */
	public RouletteLogic() {}

	/**
	 * 名前とカウントを受け取り、結果を返す
	 * @param name 名前
	 * @param cnt カウント
	 * @return result 結果
	 */
	public Result execute(String name, int cnt) {
		RandomLogic random = new RandomLogic();
		String key = random.random();
		Result result = new Result();

		if(cnt < 5){
			// カウント５未満ならランダム結果を格納
			result.setResultMessage(getInstruction(key));
			result.setResultColor(getColorCode(key));
			editInstruction(result, name);
		} else {
			// ５以上ならＸＸＸ
			result.setResultMessage("もうやらないよー(-_-)");
			result.setResultColor("#fdeff2");
		}
		return result;
	}

	/**
	 * keyにあったメッセージを取得
	 * @param key キー
	 * @return result
	 */
	private String getInstruction(String key) {
		String file = "C:/pleiades/workspace/Kensyu/src/properties/testMessage.properties";
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(isr);

			properties.load(reader);
			inputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "エラー";
		}
		return properties.getProperty(key).toString();
	}

	/**
	 * キーからカラーコードの取得
	 * @param key
	 * @return
	 */
	private String getColorCode(String key) {
		String file = "C:/pleiades/workspace/Kensyu/src/properties/colorCode.properties";
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader reader = new BufferedReader(isr);

			properties.load(reader);
			inputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "#fdeff2";
		}
		return properties.getProperty(key).toString();
	}

	/** メッセージの編集
	 * @param result
	 * @return result */
	private Result editInstruction(Result result,String name) {
			result.setResultMessage("今日の" + name + "さんのラッキーカラーは" + result.getResultMessage() + "色だよ");
		return result;
	}
}