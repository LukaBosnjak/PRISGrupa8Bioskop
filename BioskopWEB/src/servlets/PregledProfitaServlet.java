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

/**
 * Servlet implementation class PregledProfitaServlet
 */
@WebServlet("/PregledProfitaServlet")
public class PregledProfitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AdministratorBeanRemote abr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledProfitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datumOd = new Date();
		Date datumDo = new Date();
		
		try {
			datumOd = sdf.parse(request.getParameter("datumOd"));
			datumDo = sdf.parse(request.getParameter("datumDo"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		double profit = abr.profitUPeriodu(datumOd, datumDo);
		
		String porukaProfit = "Vas profit u period od "+datumOd+" do "+datumDo+" je: "+profit;
		
		request.getSession().setAttribute("porukaProfit", porukaProfit);
		
		request.getRequestDispatcher("/profitPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
