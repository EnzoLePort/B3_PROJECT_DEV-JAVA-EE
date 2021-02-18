package fr.epsi.service;

import java.util.List;

import javax.ejb.Stateless;

import fr.epsi.entite.Idea;

public interface IdeaService {

	public List<Idea> getIdeas();
	
	void add(Idea idea); 
	
}
