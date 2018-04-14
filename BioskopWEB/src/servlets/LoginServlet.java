package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BioskopBeanRemote;
import model.Korisnik;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BioskopBeanRemote bbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		Korisnik ulogovan = bbr.login(user, password);
		
		if (ulogovan != null) {
			request.getSession().setAttribute("user", ulogovan);
		}
		
		if (ulogovan.getRola().equalsIgnoreCase("admin")) {
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
		}
		
		if (ulogovan.getRola().equalsIgnoreCase("koirisnik")) {
			request.getRequestDispatcher("/userPage.jsp").forward(request, response);
		}
		//request.getRequestDispatcher("/indexLoggedIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
