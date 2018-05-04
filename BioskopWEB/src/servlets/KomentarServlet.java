package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BioskopBeanRemote;
import model.Film;
import model.Komentar;
import model.Korisnik;

/**
 * Servlet implementation class KomentarServlet
 */
@WebServlet("/KomentarServlet")
public class KomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BioskopBeanRemote bbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nazivFilma = request.getParameter("film");
		Film f = bbr.getFilmZaNaziv(nazivFilma);
		
		Komentar k = null;
		Date datum = new Date();
		String txtKomentara = request.getParameter("komentar");
		Korisnik user = (Korisnik) request.getSession().getAttribute("user");
		
		Komentar postavljen = bbr.komentarisi(datum, txtKomentara, f, user, k);
		String poruka= "";
		
		if (postavljen != null) {
			poruka = "Ok";
		}else {
			poruka = "Greska";
		}
		
		request.getSession().setAttribute("porukaComment", poruka);
		request.getRequestDispatcher("/commentForm.jsp").forward(request, response);
		
	}

}
