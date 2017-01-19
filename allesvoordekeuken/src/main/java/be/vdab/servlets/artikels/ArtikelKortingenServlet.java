package be.vdab.servlets.artikels;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class ArtikelKortingenServlet
 */
@WebServlet("/artikels/kortingen.htm")
public class ArtikelKortingenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW  = "/WEB-INF/JSP/artikels/kortingen.jsp";
	private static final ArtikelService artikelService = new ArtikelService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtikelKortingenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("artikels", artikelService.findAll());
		if(request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			artikelService.read(id).ifPresent(artikel -> request.setAttribute("kortingArtikel", artikel));
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}


}
