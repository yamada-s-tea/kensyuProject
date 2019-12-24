package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlayServlet3
 */
@WebServlet("/PlayServlet3")
public class PlayServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

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

		// 詳細一覧に飛ばすだけ
		foward(req, res, "/WEB-INF/view4/equipDetails.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		initCharType(req, res);
		// HttpSession session = req.getSession();

		foward(req, res, "/WEB-INF/view3/equipDetails.jsp");
	}

}
