package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Idea;
import fr.epsi.service.RateIdeaService;

public class RateIdeaServlet extends HttpServlet {
	
	@EJB
	private RateIdeaService service;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Idea idea = new Idea();
		idea.setId(Long.parseLong(req.getParameter("id")));
		
		req.setAttribute("idee", idea);
		req.setAttribute("listRateIdea", service.getRateIdea(idea));
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/rates-idea.jsp").forward(req, resp);
	}
	
	
	
}
