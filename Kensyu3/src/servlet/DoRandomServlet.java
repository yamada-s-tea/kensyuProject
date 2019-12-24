package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.RouletteLogic;
import logic.ValidationLogic;
import beans.Name;
import beans.Result;

/**
 * Servlet implementation class DoRandomServlet
 */
@WebServlet("/DoRandomServlet")
public class DoRandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /** 引数なしコンストラクタ
     * @see HttpServlet#HttpServlet() */
    public DoRandomServlet() { super(); }

	/**
	 * GETリクエストの場合
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// フォワード先パスの格納変数（初期化）
		String fowardPath = null;
		String beforePage = null;
		beforePage = request.getParameter("beforePage");

		if(beforePage==null || beforePage.equals("result")) {

			// 前ページ無し、もしくは結果画面のタイトルボタン押下時
			// セッションを削除
			HttpSession session = request.getSession();
			session = request.getSession(false);
			if(session != null){
			// session.removeAttribute("result");
			session.invalidate();
			System.out.println("セッション削除を実行しました");
			}

			// フォワード先の設定、フォワード
			fowardPath = "/WEB-INF/view/includeTest.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
			dispatcher.forward(request, response);
		} else if(beforePage.equals("title")) {

			// フォワード先の設定、フォワード
			fowardPath = "/WEB-INF/view/inputName.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * POSTリクエストの場合
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// フォワード先パスの格納変数（初期化）
		String fowardPath = null;
		String beforePage = null;
		beforePage = request.getParameter("beforePage");

		if(beforePage==null) {

			// タイトルへ
			fowardPath = "/WEB-INF/view/includeTest.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
			dispatcher.forward(request, response);
		} else if(beforePage.equals("inputName")) {

			int cnt = 0;
			// 名前を入力後、ルーレットが押された場合の処理
			Result result = new Result();
			ValidationLogic vali = new ValidationLogic();
			Name name = new Name();
			// 名前を格納
			name.setName(request.getParameter("name"));

			// 名前の入力にエラーがあればエラーページへ
			if(!vali.nameVal(name.getName())){
				result.setResultMessage("名前入力エラー");
				result.setResultColor("error");
				System.out.println("error");
			}

			// フォワード先の設定、フォワード
			if(result.getResultColor()=="error"){
				fowardPath = "/WEB-INF/view/error.jsp";
			}else{
				RouletteLogic logic = new RouletteLogic();
				result = logic.execute(name.getName(),cnt);
				fowardPath = "/WEB-INF/view/result.jsp";
			}

			// セッションに結果格納
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
			session.setAttribute("name", name);
			cnt += 1;
			session.setAttribute("cnt", cnt);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
			dispatcher.forward(request, response);
		} else if(beforePage.equals("result")) {

			// もう一回ボタン押下時
			Result result = new Result();
			HttpSession session = request.getSession();
			RouletteLogic logic = new RouletteLogic();
			Name name = (Name) session.getAttribute("name");
			int cnt = (int) session.getAttribute("cnt");
			result = logic.execute(name.getName(),cnt);
			session.setAttribute("result", result);
			cnt += 1;
			session.setAttribute("cnt", cnt);

			// フォワード先の設定、フォワード
			fowardPath = "/WEB-INF/view/result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(fowardPath);
			dispatcher.forward(request, response);

		}
	}
}
