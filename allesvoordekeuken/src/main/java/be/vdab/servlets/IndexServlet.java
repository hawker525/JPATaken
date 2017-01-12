package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Maarten Westelinck on 19/12/2016.
 *
 */
@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/index.jsp";
    private static final Random random = new Random();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("randomLogo", random.nextInt(3) + 1);
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
