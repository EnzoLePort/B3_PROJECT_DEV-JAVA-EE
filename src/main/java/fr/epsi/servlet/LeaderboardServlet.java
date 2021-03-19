package fr.epsi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.service.IdeaService;
import fr.epsi.service.UserService;

public class LeaderboardServlet extends HttpServlet {
	
	@EJB
	private IdeaService serviceIdea;
	
	@EJB
	private UserService serviceUser;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listIdeasTopRating", serviceIdea.getTopRatingIdeas());
		req.setAttribute("listIdeasBestRating", serviceIdea.getBestRatingIdeas());
		req.setAttribute("listUsersBestRating", serviceUser.getBestRatingUsers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/page/leaderboard.jsp").forward(req, resp);
	}

}
