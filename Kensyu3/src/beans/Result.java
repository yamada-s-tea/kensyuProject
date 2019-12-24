package beans;

import java.io.Serializable;

public class Result implements Serializable{

	private static final long serialVersionUID = 1L;

	private String resultMessage;
	private String resultColor;

	/** 引数なしコンストラクタ */
	public Result(){
		resultMessage = null;
		resultColor = "#fdeff2"; // 薄桜
	}

	/** メッセージの取得
	 * @return resultMessage 結果メッセージ */
	public String getResultMessage() {
		return resultMessage;
	}

	/** メッセージのセット
	 * @param resultMessage 結果メッセージ */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	/** カラーコードの取得
	 * @return resultColor 結果カラーコード */
	public String getResultColor() {
		return resultColor;
	}

	/** カラーコードのセット
	 * @param resultColor 結果カラーコード */
	public void setResultColor(String resultColor) {
		this.resultColor = resultColor;
	}

}
