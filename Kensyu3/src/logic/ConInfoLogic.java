package logic;

import beans.ConInfoBean;
import beans.RegistInfoBean;

public class ConInfoLogic {

	/** 引数なしコンストラクタ */
	public ConInfoLogic(){};

	/** 登録情報を受け取り、表示用に加工、変換を行う */
	public ConInfoBean conInfo(RegistInfoBean RIBean, ConInfoBean CIBean){
		CIBean.setName(RIBean.getName());
		CIBean.setAge(RIBean.getAge());
		if(RIBean.isSex()){
			CIBean.setSex("女");
		} else {
			CIBean.setSex("男");
		}
		CIBean.setAdress(RIBean.getAdress());
		CIBean.setBiko(RIBean.getBiko());
		return CIBean;
	}
}