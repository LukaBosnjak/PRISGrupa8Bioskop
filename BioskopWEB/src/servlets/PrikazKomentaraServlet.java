package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BioskopBeanRemote;
import model.Film;
import model.Komentar;

/**
 * Servlet implementation class PrikazKomentaraServlet
 */
@WebServlet("/PrikazKomentaraServlet")
public class PrikazKomentaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BioskopBeanRemote bbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazKomentaraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nazivFilma = request.getParameter("film");
		Film f = bbr.getFilmZaNaziv(nazivFilma);
		
		List<Komentar> komentari = bbr.getKomentariZaFilm(f);
		
		request.setAttribute("komentari", komentari);
		request.getRequestDispatcher("/pregledKomentaraPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> sviFilmovi = bbr.getSviFilmovi();
		request.setAttribute("sviKomentarisaniFilmovi", sviFilmovi);
		request.getRequestDispatcher("/pregledKomentaraPage.jsp").forward(request, response);
	}

}
