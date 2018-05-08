package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FilmoviBeanRemote;
import model.Film;

/**
 * Servlet implementation class FilmoviPoKategorijamaServlet
 */
@WebServlet("/FilmoviPoKategorijamaServlet")
public class FilmoviPoKategorijamaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	FilmoviBeanRemote fbr;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmoviPoKategorijamaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Film> filmoviPoZanru = fbr.izlistajFilmovePoZanru("Akcija"/*request.getParameter("zanr")*/);
		List<Film> filmoviPoOceni = fbr.izlistajFilmovePoOceni();
		request.setAttribute("filmoviPoKategoriji", filmoviPoOceni);
		request.getRequestDispatcher("filmoviPoKategorijama.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
