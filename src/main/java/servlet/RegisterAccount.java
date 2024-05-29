package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.RegisterLogic;

/**
 * Servlet implementation class RegisterAccount
 */
@WebServlet("/RegisterAccount")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String forwardPath = null;
		
		String action = request.getParameter("action");
		
		if(action == null) {
			forwardPath = "WEB-INF/jsp/registerForm.jsp";
		} else if(action.equals("done")) {
			HttpSession session = request.getSession();
			Account registerAccount = (Account)session.getAttribute("registerAccount");
			
			RegisterLogic logic = new RegisterLogic();
			logic.execute(registerAccount);
			
			session.removeAttribute("registerAccount");
			
			forwardPath = "WEB-INF/jsp/registerDone.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		
		Account registerAccount = new Account(userId, pass, mail, name);
		
		HttpSession session = request.getSession();
		session.setAttribute("registerAccount", registerAccount);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}

}
