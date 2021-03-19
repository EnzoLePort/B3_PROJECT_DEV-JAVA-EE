package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idea;

public interface IdeaDAO {

	List<Idea> getIdeas();
	
	List<Idea> getTopRatingIdeas();
	
	List<Idea> getBestRatingIdeas();
	
	void add(Idea idea);
	
}
