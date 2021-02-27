package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idea;
import fr.epsi.entite.RateIdea;

public interface RateIdeaDAO {

	List<RateIdea> getRateIdea(Idea idea);

}
