package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.User;
import fr.epsi.service.UserService;

public class AdminServlet extends HttpServlet {
	
	@EJB
	private UserService service;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	User user = (User) session.getAttribute("user");
    	if(user.getRank() == 1) {
    		req.setAttribute("listSubscribes", service.getSubscribeWaiting());
    		this.getServletContext().getRequestDispatcher("/WEB-INF/page/admin.jsp").forward(req, resp);
    	}
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	User user = (User) session.getAttribute("user");
    	if(user.getRank() == 1) {
    		service.approveSubscribe(Long.parseLong(req.getParameter("id")));
    		req.setAttribute("listSubscribes", service.getSubscribeWaiting());
    		this.getServletContext().getRequestDispatcher("/WEB-INF/page/admin.jsp").forward(req, resp);
    	}
    }

}
