package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BioskopBeanRemote;

/**
 * Servlet implementation class RegistracijaServlet
 */
@WebServlet("/RegistracijaServlet")
public class RegistracijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BioskopBeanRemote bbr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaServlet() {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("imeRegister");
		String password = request.getParameter("prezRegister");
		String role = request.getParameter("mailRegister");
		/*String path = request.getParameter("image");
		System.out.println(path);
		File f = new File(path);
		Path p = f.toPath();
		byte[] slika = Files.readAllBytes(p);*/
		byte[] slika = new byte[] {1, 2, 3};
		String poruka = "";
		
		boolean r = bbr.registracija(username, password, role, slika);
		
		if (r) {
			poruka = "Uspesno ste se registrovali";
		}else {
			poruka = "Doslo je do greske";
		}
		
		request.getSession().setAttribute("poruka", poruka);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

}
