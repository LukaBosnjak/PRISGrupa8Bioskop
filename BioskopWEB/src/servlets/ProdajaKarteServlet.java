package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RadnikBeanRemote;

/**
 * Servlet implementation class ProdajaKarteServlet
 */
@WebServlet("/ProdajaKarteServlet")
public class ProdajaKarteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	RadnikBeanRemote rbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdajaKarteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rezervacije", rbr.getRezervacijeZaProjekciju(1));//idProjekcije);
		request.getRequestDispatcher("prodajaKarte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(rbr.prodajKartu(1/*Integer.parseInt(request.getParameter("idRezervacije"))*/)) {
			request.setAttribute("rezervacije", rbr.getRezervacijeZaProjekciju(1));
			request.setAttribute("successMessage", "Karta prodata");
			request.getRequestDispatcher("prodajaKarte.jsp").forward(request, response);
		}
	}

}
