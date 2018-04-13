package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FilmoviBeanRemote;
import model.Film;

/**
 * Servlet implementation class FilmoviServlet
 */
@WebServlet("/FilmoviServlet")
public class FilmoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FilmoviBeanRemote fbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmoviServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Film film = fbr.nadijFilm(Integer.parseInt(request.getParameter("idFilma")));
		request.setAttribute("movieTrailer", film.getLinkTrejlera());
		request.setAttribute("movieTitle", film.getNaziv());
		request.setAttribute("movieTitle2", film.getUloge());
		request.setAttribute("movieZanr", film.getZanr());
		request.setAttribute("description", film.getOpis());
		getServletContext().getRequestDispatcher("FilmTmp.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
