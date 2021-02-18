package fr.epsi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/home.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = req.getParameter("email");
    	String password = req.getParameter("password");
    	HttpSession session = req.getSession();
    	session.setAttribute("email", email);
    	session.setAttribute("password", password);
    	this.getServletContext().getRequestDispatcher("/WEB-INF/page/home.jsp").forward(req, resp);
    }
}
