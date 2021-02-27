package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.entite.Idea;
import fr.epsi.entite.Rate;
import fr.epsi.entite.RateIdea;
import fr.epsi.entite.User;
import fr.epsi.service.RateIdeaService;

public class CreateRateIdeaServlet extends HttpServlet {
	
	@EJB
	private RateIdeaService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idIdea = Integer.parseInt(req.getParameter("id"));
		int note = Integer.parseInt(req.getParameter("note"));
		req.setAttribute("note", note);
		req.setAttribute("id", idIdea);
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/create-rateIdea.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupération paramètres POST
		Long idIdea = Long.parseLong(req.getParameter("idIdea"));
		int note = Integer.parseInt(req.getParameter("note"));
		String comment = req.getParameter("comment");
		
		// Récupératioon User
    	HttpSession session = req.getSession();
    	User user = (User) session.getAttribute("user");
    	
    	//Création objet Idea
    	Idea idea = new Idea();
    	idea.setId(idIdea);
		
    	// Création objet Rate
		Rate rate = new Rate();
		if(note == 1) {
			rate.setId(Long.parseLong("2"));
			rate.setName("Top");
		} else {
			rate.setId(Long.parseLong("1"));
			rate.setName("Flop");
		}
		
		RateIdea rateIdea = new RateIdea();
		rateIdea.setComment(comment);
		rateIdea.setUser(user);
		rateIdea.setIdea(idea);
		rateIdea.setRate(rate);
		
		service.add(rateIdea);
		
		resp.sendRedirect("rates-idea?id="+idIdea);
	}
	
}
