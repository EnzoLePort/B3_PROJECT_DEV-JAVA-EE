package fr.epsi.service;

import java.util.List;

import javax.ejb.Stateless;

import fr.epsi.entite.Idea;

public interface IdeaService {

	List<Idea> getIdeas();
	
	List<Idea> getTopRatingIdeas();
	
	void add(Idea idea); 
	
}
