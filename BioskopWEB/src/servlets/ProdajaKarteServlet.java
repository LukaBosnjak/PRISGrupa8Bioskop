package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RadnikBeanRemote;
import model.Rezervacije;

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
		List<Rezervacije> rezervacije = rbr.getRezervacije();
		for(Rezervacije rezervacija : rezervacije) {
			System.out.println(rezervacija);
		}
		request.setAttribute("rezervacije", rezervacije);
		request.getRequestDispatcher("prodajaKarte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
