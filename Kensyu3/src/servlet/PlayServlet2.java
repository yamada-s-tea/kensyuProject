package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BackArmorShopLogic;
import logic.BuyLogic;
import logic.MakeEquipmentListLogic;
import beans.AllyBean;
import beans.BattleBean;
import beans.EquipmentBean;

/**
 * Servlet implementation class PlayServlet2
 */
@WebServlet("/PlayServlet2")
public class PlayServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /** @see HttpServlet#HttpServlet() */
    public PlayServlet2() {super();}

    /** 文字コードセット */
    private void initCharType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	}

    /** フォワード */
    private void foward(HttpServletRequest req, HttpServletResponse res,String path) throws ServletException, IOException{
    	RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, res);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		initCharType(req, res);

		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
			System.out.println("セッションを削除しました");
		}
		foward(req,res,"/WEB-INF/view/includeTest.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		initCharType(req, res);
		HttpSession session = req.getSession();

		if (req.getParameter("beforePage") == null) {
			// 遷移元：なし
			if (session != null) {
				session.invalidate();
				System.out.println("セッションを削除しました。遷移元がありません。");
			}
			foward(req,res,"/WEB-INF/view/includeTest.jsp");
		} else if (req.getParameter("beforePage").equals("armorShop")) {

			if (req.getParameter("back") != null && req.getParameter("back").equals("装備を確定して戻る")) {
				List<EquipmentBean> equipList = (List<EquipmentBean>)session.getAttribute("equipList");
				int cnt = 0;
				AllyBean main = (AllyBean) session.getAttribute("main");
				BattleBean battleBean = new BattleBean();
				BackArmorShopLogic logic = new BackArmorShopLogic();
				for (int i = 0; i < equipList.size(); i++) {
					if (req.getParameter("ing" + i) != null
							&& req.getParameter("ing" + i).equals("true")) {
						logic.addEquip(main, battleBean, equipList.get(i).getId(), cnt);
						cnt++;
						if (cnt == 2) {
							break;
						}
					}
				}
				logic.confirmEquip(main, battleBean, cnt);
				session.setAttribute("main", main);
				session.removeAttribute("battleBean");
				foward(req, res, "/WEB-INF/view2/choosePlace.jsp");
			}

			List<EquipmentBean> goodsList = MakeEquipmentListLogic.makeGoodsList();
			for (int i = 0; i < goodsList.size(); i++) {
				if (req.getParameter("buy" + i) != null
						&& req.getParameter("buy" + i).equals("購入")) {
					AllyBean main = (AllyBean) session.getAttribute("main");
					BattleBean battleBean = new BattleBean();
					BuyLogic buyLogic = new BuyLogic();
					// 購入処理
					buyLogic.buy(main, battleBean, goodsList, goodsList.get(i).getId());
					session.setAttribute("main", main);
					session.setAttribute("battleBean", battleBean);
					foward(req, res, "/WEB-INF/view3/armorShop.jsp");
					return;
				}
			}
		}
	}
}
