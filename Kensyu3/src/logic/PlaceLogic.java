package logic;

import beans.EnemyBean;

/** 敵の現れる場所におけるロジックの親クラス */
public abstract class PlaceLogic {

	public PlaceLogic() {}

	/** 敵の生成メソッド */
	public abstract EnemyBean createEnemy();

}
