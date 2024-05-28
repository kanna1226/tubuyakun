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

import dao.AccountsDAO;
import model.Account;
import model.GetMutterListLogic;
import model.Login;
import model.Mutter;
import model.PostMutterLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		HttpSession session = request.getSession();
		Login loginUser = (Login)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("index.jsp");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		if (text != null && text.length() != 0) {
			HttpSession session = request.getSession();
			Login loginUser = (Login)session.getAttribute("loginUser");
			
			AccountsDAO dao = new AccountsDAO();
			Account loginAccount = dao.findByLogin(loginUser);
			
			Mutter mutter = new Mutter(loginAccount.getUserId(), loginAccount.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
		} else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
