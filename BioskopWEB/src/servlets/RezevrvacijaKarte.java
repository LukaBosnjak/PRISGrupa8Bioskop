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
 * Servlet implementation class RezevrvacijaKarte
 */
@WebServlet("/RezevrvacijaKarte")
public class RezevrvacijaKarte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BioskopBeanRemote bbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezevrvacijaKarte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("projekcije", bbr.getProjekcije());
		request.getRequestDispatcher("RezervacijaKarata.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(bbr.rezervisi((Korisnik)request.getSession().getAttribute("user"), Integer.parseInt(request.getParameter("idProjekcije")))) {
			request.setAttribute("successMessage", "Uspesno ste rezervisali kartu.");
			request.getRequestDispatcher("RezervacijaKarata.jsp").forward(request, response);
		}
		request.setAttribute("successMessage", "Doslo je do greske.");
		request.getRequestDispatcher("RezervacijaKarata.jsp").forward(request, response);
	}

}
