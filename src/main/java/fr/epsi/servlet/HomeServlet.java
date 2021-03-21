package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.User;
import fr.epsi.service.RateService;
import fr.epsi.service.UserService;

public class HomeServlet extends HttpServlet {
	
	@EJB
	private UserService serviceUser;
	
	@EJB
	private RateService serviceRate;
	
	

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Vérification de la présence des données flop et top dans la table rate. Sinon remplissage de ces données
		serviceRate.checkDataTopFlop();
		
		// Deconnexion si l'utilisateur est connecté
    	HttpSession session = req.getSession();
    	session.removeAttribute("user");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/home.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = req.getParameter("j_username");
    	String password = req.getParameter("j_password");
    	User user = serviceUser.get(email, password);
    	if(user != null && user.getRank() >=0) {
        	HttpSession session = req.getSession();
        	session.setAttribute("user", user);
        	resp.sendRedirect("list-ideas");
    	} else {
	    	req.setAttribute("error", "Les identifiants ne sont pas valides !");
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/page/home.jsp").forward(req, resp);
    	}
    }
}
