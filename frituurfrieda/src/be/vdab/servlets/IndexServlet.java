package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";

    /**
     * Default constructor. 
     */
    public IndexServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dag = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		Adres adres = new Adres();
		adres.setStraat("testStraat");
		adres.setHuisNr("1");
		adres.setGemeente(new Gemeente());
		adres.getGemeente().setNaam("Wondelgem");
		adres.getGemeente().setPostCode(9940);
		String openGesloten = (dag == Calendar.MONDAY || dag == Calendar.THURSDAY) ? "gesloten" : "open";

		request.setAttribute("adres", adres);
		request.setAttribute("openGesloten", openGesloten);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
