package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.User;
import fr.epsi.service.UserService;

public class SubscribeServlet extends HttpServlet {
	
	@EJB
	private UserService service;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/subscribe.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	// Cr�ation de l'objet User
    	User user = new User();
    	user.setFirstName(req.getParameter("firstname"));
    	user.setName(req.getParameter("lastname"));
    	user.setMail(req.getParameter("email"));
    	user.setPassword(req.getParameter("password"));
    	// le rank -1 est le signe que la candidature est en attente, 0 sera valid� et le rank 1 signifie que l'utilisateur est admin
    	user.setRank(-1);
    	
    	// Cr�ation de la candidature dans la base de donn�es
    	service.subscribe(user);
    	req.setAttribute("success", "Votre candidature a bien �t� transmise ! Elle sera �tudi�e par un administrateur prochainement");
    	
    	this.getServletContext().getRequestDispatcher("/WEB-INF/page/subscribe.jsp").forward(req, resp);
    }
	
}
