package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AdministratorBeanRemote;
import model.Film;
import model.Sala;

/**
 * Servlet implementation class unosRepertoaraServlet
 */
@WebServlet("/unosRepertoaraServlet")
public class UnosRepertoaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AdministratorBeanRemote abr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosRepertoaraServlet() {
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datum = new Date();
		String tip = request.getParameter("tipRepertoara");
		String nazivFilma = request.getParameter("nazivFilma");
		int brSale = Integer.parseInt(request.getParameter("brSale"));
		String porukaRepertoar = "";
		boolean unet = false;
		
		try {
			datum = sdf.parse(request.getParameter("datumRepertoar"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Film f = abr.getFilmZaNaziv(nazivFilma);
		Sala s = abr.getSalaZaBrSale(brSale);
		
		if (f != null && s != null) {
			unet = abr.unos(datum, tip, s, f);
		}
		
		if (unet) {
			porukaRepertoar = "Uspesno ste uneli repertoar";
			request.getSession().setAttribute("porukaRepertoar", porukaRepertoar);
		}else {
			porukaRepertoar = "Doslo je do greske";
			request.getSession().setAttribute("porukaRepertoar", porukaRepertoar);
		}
		
		request.getRequestDispatcher("/UnosRepertoaraPage.jsp").forward(request, response);
		
	}

}
