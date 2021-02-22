package fr.epsi.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Idea;
import fr.epsi.service.IdeaService;
import fr.epsi.service.UserService;

public class CreateIdeaServlet extends HttpServlet {
	
	@EJB
	private IdeaService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/create-idea.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 
		String title = req.getParameter("title");
    	String description = req.getParameter("description");
		String type = req.getParameter("type");
    	String picture = req.getParameter("picture");

    	Date today = new Date();
    	
    	Idea idea = new Idea();
    	idea.settitle(title);
    	idea.setDescription(description);
    	idea.settype(type);
    	idea.setDate(today);
    	
    	service.add(idea);
    	req.setAttribute("sucess", "l'idee a bien été publiée");
    	
    	this.getServletContext().getRequestDispatcher("/WEB-INF/page/create-idea.jsp").forward(req, resp);
		
	}

}
