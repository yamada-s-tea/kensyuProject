package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Kensyu4Servlet
 */
@WebServlet("/Kensyu4Servlet")
public class Kensyu4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kensyu4Servlet() { super(); }

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
		initCharType(req,res);

		HttpSession session = req.getSession(false);
		if (session != null) {
			// セッション削除
			session.invalidate();
			System.out.println("セッションを削除しました");
		}
		// 初期画面へ
		foward(req,res,"/WEB-INF/view/includeTest.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		initCharType(req,res);
		// HttpSession session = req.getSession();

		if (req.getParameter("beforePage") == null) {
			// 遷移元：なし
			foward(req, res, "/WEB-INF/view/includeTest.jsp");
		} else if (req.getParameter("beforePage").equals("includeTest")) {
			// 遷移元：テストページ
			foward(req, res, "/WEB-INF/view3/Learning.jsp");
		}
	}

}
