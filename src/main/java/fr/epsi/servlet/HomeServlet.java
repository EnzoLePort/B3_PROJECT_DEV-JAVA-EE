package fr.epsi.servlet;

import java.io.IOException;
import java.security.Principal;

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
		// Deconnexion si l'utilisateur est connect�
    	HttpSession session = req.getSession();
		if(req.getParameter("disconnect") != null && req.getParameter("disconnect").equals("true")) {
			System.out.println("DECONNECTER !!");
			session.removeAttribute("user");
		} else if(req.getUserPrincipal() != null) {
	    	User user = serviceUser.get(req.getUserPrincipal().toString());
	    	session.setAttribute("user", user);
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/page/list-ideas.jsp").forward(req, resp);
		}
		// V�rification de la pr�sence des donn�es flop et top dans la table rate. Sinon remplissage de ces donn�es
		serviceRate.checkDataTopFlop();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/home.jsp").forward(req, resp);
    }
}
