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

import logic.BattleLogic;
import logic.CastleLogic;
import logic.GlasslandLogic;
import logic.MakeEquipmentListLogic;
import logic.MountainLogic;
import logic.RestLogic;
import logic.RiverLogic;
import logic.SeaLogic;
import logic.SecludedCaveLogic;
import logic.SecludedForestLogic;
import logic.TheHarunaLogic;
import beans.AllyBean;
import beans.BattleBean;
import beans.EnemyBean;
import beans.EquipmentBean;

/** Servlet implementation class PlayServlet */
@WebServlet("/PlayServlet")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /** @see HttpServlet#HttpServlet() */
    public PlayServlet() {super();}

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
			// session.removeAttribute("CIBean");
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
		} else if (req.getParameter("beforePage").equals("choosePlace")) {
			// 遷移元：行先選択画面
			if (req.getParameter("place") == null) {
				foward(req, res, "/WEB-INF/view/includeTest.jsp");
			} else if(req.getParameter("place").equals("0")){
				// 草原選択時
				GlasslandLogic GlLogic = new GlasslandLogic();
				EnemyBean enemy = GlLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("grassland");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/grassland.jsp");
			} else if(req.getParameter("place").equals("1")){
				// 川選択時
				RiverLogic RLogic = new RiverLogic();
				EnemyBean enemy = RLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("river");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/river.jsp");
			} else if(req.getParameter("place").equals("2")){
				// 海選択時
				SeaLogic seaLogic = new SeaLogic();
				EnemyBean enemy = seaLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("sea");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/sea.jsp");
			} else if(req.getParameter("place").equals("3")){
				// 山選択時
				MountainLogic MtLogic = new MountainLogic();
				EnemyBean enemy = MtLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("mountain");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/mountain.jsp");
			} else if(req.getParameter("place").equals("4")){
				// 城選択時
				CastleLogic castleLogic = new CastleLogic();
				EnemyBean enemy = castleLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("castle");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/castle.jsp");
			} else if(req.getParameter("place").equals("5")){
				// 秘境(洞窟)選択時
				SecludedCaveLogic secCaveLogic = new SecludedCaveLogic();
				EnemyBean enemy = secCaveLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("secludedCave");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/secludedCave.jsp");
			} else if(req.getParameter("place").equals("6")){
				// 秘境(密林)選択時
				SecludedForestLogic secForestLogic = new SecludedForestLogic();
				EnemyBean enemy = secForestLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("secludedForest");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/secludedForest.jsp");
			} else if(req.getParameter("place").equals("7")){
				// 榛名選択時
				TheHarunaLogic harunaLogic = new TheHarunaLogic();
				EnemyBean enemy = harunaLogic.createEnemy();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("theHaruna");
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/theHaruna.jsp");
			} else if(req.getParameter("place").equals("8")){
				// 武具屋選択時
				AllyBean main = (AllyBean)session.getAttribute("main");
				List<EquipmentBean> equipList = MakeEquipmentListLogic.makeHaveList(main);
				List<EquipmentBean> goodsList = MakeEquipmentListLogic.makeGoodsList();
				BattleBean battleBean = new BattleBean();
				battleBean.setPlace("armorShop");
				session.setAttribute("equipList", equipList);
				session.setAttribute("goodsList", goodsList);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view3/armorShop.jsp");
			} else if(req.getParameter("place").equals("9")){
				// 小屋で休憩選択時
				RestLogic restLogic = new RestLogic();
				BattleBean battleBean = new BattleBean();
				AllyBean main = (AllyBean)session.getAttribute("main");
				restLogic.rest(main,battleBean);
				session.setAttribute("main", main);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/choosePlace.jsp");
			} else if(req.getParameter("place").equals("10")){
				// 宿で休む選択時
				RestLogic restLogic = new RestLogic();
				BattleBean battleBean = new BattleBean();
				AllyBean main = (AllyBean)session.getAttribute("main");
				restLogic.restAll(main,battleBean);
				session.setAttribute("main", main);
				session.setAttribute("battleBean", battleBean);
				foward(req, res, "/WEB-INF/view2/choosePlace.jsp");
			}
/* ☆☆☆各フィールドでの戦闘コマンド入力後☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
		} else if(req.getParameter("beforePage").equals("battle")) {
			// 遷移元：戦闘
			AllyBean main = (AllyBean)session.getAttribute("main");
			EnemyBean enemy = (EnemyBean)session.getAttribute("enemy");
			BattleBean battleBean = (BattleBean)session.getAttribute("battleBean");
			String beforePage = battleBean.getPlace();
			BattleLogic battleLogic = new BattleLogic();
			if(req.getParameter("command").equals("たたかう")){
				// たたかう押下時
				battleLogic.battle(main, enemy, battleBean);
				session.setAttribute("main", main);
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				if(battleBean.getContFlg() == 1){
					// 続行の場合
					foward(req,res,"/WEB-INF/view2/"+ beforePage +".jsp");
				} else if(battleBean.getContFlg() == 2) {
					// 戦闘終了の場合（敗北）
					foward(req,res,"/WEB-INF/view2/gameOver.jsp");
				} else if(battleBean.getContFlg() == 3){
					// 戦闘終了の場合（勝利）
					foward(req,res,"/WEB-INF/view2/battleResult.jsp");
				}

			} else if(req.getParameter("command").equals("にげる")){
				// にげる押下時
				battleLogic.escape(main, enemy, battleBean);
				session.setAttribute("main", main);
				session.setAttribute("enemy", enemy);
				session.setAttribute("battleBean", battleBean);
				if(battleBean.getContFlg() == 1){
					foward(req,res,"/WEB-INF/view2/"+ beforePage +".jsp");
				} else if(battleBean.getContFlg() == 4){
					foward(req,res,"/WEB-INF/view2/battleResult.jsp");
				} else if(battleBean.getContFlg() == 2){
					foward(req,res,"/WEB-INF/view2/gameOver.jsp");
				}
			}
/* ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
		} else if(req.getParameter("beforePage").equals("battleResult")){
			// 遷移元：戦闘結果画面
			session.removeAttribute("battleBean");
			foward(req, res, "/WEB-INF/view2/choosePlace.jsp");
/* ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
		} else { // 遷移元での判別が出来なかった場合
			if (session != null) {
				String beforePage = req.getParameter("beforePage");
				session.invalidate();
				System.out.println("セッションを削除しました。遷移元が不明です。");
				System.out.println(beforePage);
			}
			foward(req,res,"/WEB-INF/view/includeTest.jsp");
		}

	}
}
