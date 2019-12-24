package beans;

import java.io.Serializable;

public class Name implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 氏名 */
	private String name;

	/** 氏名取得
	 * @return name 氏名 */
	public String getName() {
		return name;
	}

	/** 氏名セット
	 * @param name 氏名 */
	public void setName(String name) {
		this.name = name;
	}

	/** 引数なしコンストラクタ */
	public Name() {}
}
