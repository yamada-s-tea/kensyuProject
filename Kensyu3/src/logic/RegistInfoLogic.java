package logic;

import javax.servlet.http.HttpServletRequest;

import beans.Adress1;
import beans.RegistInfoBean;

public class RegistInfoLogic {

	/** 引数なしコンストラクタ */
	public RegistInfoLogic(){};

	/** リクエスト情報を元に情報を登録する */
	public RegistInfoBean registInfo(HttpServletRequest req,RegistInfoBean bean){
		// 氏名
		bean.setName(req.getParameter("name1") + " " + req.getParameter("name2"));
		// 年齢
		bean.setAge(Integer.parseInt(req.getParameter("age")));
		// 性別
		if(req.getParameter("sex").equals("1")){
			bean.setSex(false); // 男
		} else if(req.getParameter("sex").equals("2")) {
			bean.setSex(true); // 女
		}
		// 住所
		Adress1 adList = new Adress1();
		bean.setAdress(adList.getAdress().get(req.getParameter("adress1")) + req.getParameter("adress2"));
		// 備考
		bean.setBiko(req.getParameter("biko"));
		return bean;
	}
}