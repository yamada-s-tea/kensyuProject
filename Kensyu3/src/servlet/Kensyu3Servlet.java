package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.CreateAllyLogic;
import beans.AllyBean;
import beans.BattleBean;

/** Servlet implementation class Kensyu3Servlet */
@WebServlet("/Kensyu3Servlet")
public class Kensyu3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /** @see HttpServlet#HttpServlet() */
    public Kensyu3Servlet() {super();}

	/** @see Servlet#init(ServletConfig) */
	public void init(ServletConfig config) throws ServletException {}

	private void initCharType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	}

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fowardPath = null;
		initCharType(request, response);

		HttpSession session = request.getSession(false);
		if (session != null) {
			// session.removeAttribute("CIBean");
			session.invalidate();
			System.out.println("セッションを削除しました");
		}
		fowardPath = "/WEB-INF/view/includeTest.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
		dispatcher.forward(request, response);
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fowardPath = null;
		initCharType(req, res);

		if(req.getParameter("beforePage")==null){
			fowardPath = "/WEB-INF/view/includeTest.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(fowardPath);
			dispatcher.forward(req, res);
		} else if(req.getParameter("beforePage").equals("includeTest")){
			fowardPath = "/WEB-INF/view2/inputData.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(fowardPath);
			dispatcher.forward(req, res);
		} else if(req.getParameter("beforePage").equals("inputData")){
			// データ入力後
			CreateAllyLogic createAlly = new CreateAllyLogic();
			AllyBean mainChar = createAlly.createMainChar(req.getParameter("name"),req.getParameter("attack"),req.getParameter("way"));
			BattleBean battleBean = new BattleBean();
			// List<EquipmentBean> equipList = MakeEquipmentList.makeList();


			HttpSession session = req.getSession();
			session.setAttribute("main", mainChar);
			session.setAttribute("battleBean", battleBean);
			// session.setAttribute("equipList", equipList);
			fowardPath = "/WEB-INF/view2/choosePlace.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(fowardPath);
			dispatcher.forward(req, res);
		}
	}

}
