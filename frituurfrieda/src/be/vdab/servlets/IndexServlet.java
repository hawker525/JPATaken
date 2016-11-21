package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
//@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html lang='nl'><head>");
		out.println("<title>Frituur Frieda</title></head>");
		int dag = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if (dag == Calendar.MONDAY || dag == Calendar.THURSDAY) {
			out.println("<p>Vandaag zijn we gesloten.</p>");
		} else {
			out.println("<p>Vandaag zijn we open.</p>");
		}
		out.println("<body><h1>");
		out.println("</h1></body></html>");
	}

}
