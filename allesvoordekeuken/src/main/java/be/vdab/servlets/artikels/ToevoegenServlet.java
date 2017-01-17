package be.vdab.servlets.artikels;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.entities.FoodArtikel;
import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class ToevoegenServlet
 */
@WebServlet("/artikels/toevoegen.htm")
public class ToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/toevoegen.jsp";
	private final transient ArtikelService artikelService = new ArtikelService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToevoegenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		String naam = request.getParameter("naam");
		if(!Artikel.isNaamValid(naam)) fouten.put("naam", "verplicht");
		BigDecimal aankoopprijs = new BigDecimal(request.getParameter("aankoopprijs"));
		if(!Artikel.isAankoopprijsValid(aankoopprijs)) fouten.put("aankoopprijs", "prijs moet minstens 0.01 euro zijn.");
		BigDecimal verkoopprijs = new BigDecimal(request.getParameter("verkoopprijs"));
		if(!Artikel.isVerkoopprijsValid(verkoopprijs, aankoopprijs)) fouten.put("verkoopprijs", "verkoopprijs moet groter zijn dan aankoopprijs.");
		if(fouten.isEmpty()) {
			Artikel artikel = null;
			String radio = request.getParameter("soort");
			switch (radio) {
			case "food":
				artikel = new FoodArtikel(naam, aankoopprijs, verkoopprijs, Integer.parseInt(request.getParameter("houdbaarheid")));
				break;
			case "nonfood":
				artikel = new FoodArtikel(naam, aankoopprijs, verkoopprijs, Integer.parseInt(request.getParameter("garantie")));
			default:
				break;
			}
			artikelService.create(artikel);
		} else {
			request.setAttribute("fouten", fouten);
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
