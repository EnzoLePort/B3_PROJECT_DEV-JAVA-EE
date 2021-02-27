package fr.epsi.service;
import java.util.List;
import fr.epsi.entite.Idea;
import fr.epsi.entite.RateIdea;
public interface RateIdeaService {
	
	void add(RateIdea rateIdea);

	List<RateIdea> getRateIdea(Idea idea);
	
}
