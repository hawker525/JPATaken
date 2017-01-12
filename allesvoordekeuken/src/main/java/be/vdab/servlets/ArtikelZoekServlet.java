package be.vdab.servlets;

import be.vdab.repositories.ArtikelRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;

/**
 * Created by Maarten Westelinck on 22/12/2016 for AllesVoorDeKeuken.
 */
@WebServlet(urlPatterns = "/artikels/zoekenopnummer.htm")
public class ArtikelZoekServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/zoekenopnummer.jsp";
    private static final ArtikelRepository artikelRepo = new ArtikelRepository();

    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getQueryString() != null) {
            try {
                artikelRepo.find(Long.parseLong(req.getParameter("id"))).ifPresent(a -> 	{ 
                																				req.setAttribute("artikel", a);
                																				req.setAttribute("winstPercent", (a.getVerkoopprijs().subtract(a.getAankoopprijs())).divide(a.getAankoopprijs()).multiply(BigDecimal.valueOf(100)));
                																			});
                																			
            } catch (NumberFormatException e) {
                ;req.setAttribute("fouten", Collections.singletonMap("id", "tik een getal"));
            }
        }
        req.getRequestDispatcher(VIEW).forward(req, resp);
    }
}
