package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idea;

public interface IdeaDAO {

	List<Idea> getIdeas();
	
	void add(Idea idea);
	
}
