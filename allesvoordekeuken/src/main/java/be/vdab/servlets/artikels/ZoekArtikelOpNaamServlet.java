package be.vdab.servlets.artikels;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class ZoekArtikelOpNaamServlet
 */
@WebServlet("/artikels/zoekartikelopnaam.htm")
public class ZoekArtikelOpNaamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/zoekartikelopnaam.jsp";
	private static final ArtikelService artikelService = new ArtikelService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZoekArtikelOpNaamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getQueryString() != null) {
			String naam = request.getParameter("naam");
			request.setAttribute("naam", "naam");
			request.setAttribute("artikels", artikelService.findArtikelByNaam(naam));
		}
		request.setAttribute("fout", "geef een naam in");
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
