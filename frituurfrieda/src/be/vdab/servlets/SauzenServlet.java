package be.vdab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.vdab.dao.SausDAO;

/**
 * Servlet implementation class SauzenServlet
 */
@WebServlet("/sauzen.htm")
public class SauzenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
	private static final SausDAO sausDao = new SausDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SauzenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sauzen", sausDao.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] sauzen = request.getParameterValues("id"); 
		if(sauzen != null && sauzen.length != 0) {
			for (String saus : sauzen) {
				long id = Long.parseLong(saus);
				sausDao.removeSausById(id);
			}
		}
		doGet(request, response);
	}

}
