package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Begroeting;
import be.vdab.entities.Persoon;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final Persoon zaakvoerder = new Persoon();

    /**
     * Default constructor. 
     */
    public IndexServlet() {
    	zaakvoerder.setVoornaam("Luigi");
    	zaakvoerder.setFamilienaam("Peperone");
    	zaakvoerder.setAantalKinderen(7);
    	zaakvoerder.setGehuwd(true);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uur = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		Adres adres = new Adres();
		adres.setStraat("Grote markt");
		adres.setHuisNr("3");
		adres.setPostcode(9700);
		adres.setGemeente("Oudenaarde");
		zaakvoerder.setAdres(adres);
		
		request.setAttribute("zaakvoerder", zaakvoerder);
		request.setAttribute("begroeting", new Begroeting());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
