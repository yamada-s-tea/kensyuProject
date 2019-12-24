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

import logic.ConInfoLogic;
import logic.RegistInfoLogic;
import beans.ConInfoBean;
import beans.RegistInfoBean;

/**
 * Servlet implementation class DivServlet
 */
@WebServlet("/Kensyu2Servlet")
public class Kensyu2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /** 引数なしコンストラクタ
     * @see HttpServlet#HttpServlet() */
    public Kensyu2Servlet() {
        super();
    }

	/** 初期処理
	 * @see Servlet#init(ServletConfig) */
	public void init(ServletConfig config) throws ServletException {
	}

	private void initCharType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	}

	/** Getリクエスト
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
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

	/** Postリクエスト
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fowardPath = null;
		initCharType(request, response);

		// 情報登録
		RegistInfoBean RIBean = new RegistInfoBean();
		RegistInfoLogic RILogic = new RegistInfoLogic();

		RIBean = RILogic.registInfo(request, RIBean);

		// 登録情報を表示形式に加工
		ConInfoBean CIBean = new ConInfoBean();
		ConInfoLogic CILogic = new ConInfoLogic();

		CIBean = CILogic.conInfo(RIBean, CIBean);

		// セッションスコープに表示形式の情報を保存
		HttpSession session = request.getSession();
		session.setAttribute("CIBean", CIBean);

		fowardPath = "/WEB-INF/view/ConInfo.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
		dispatcher.forward(request, response);
	}
}
