package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Idea;

public class IdeaDAOImpl implements IdeaDAO {
	
	EntityManager em;
	UserTransaction utx;
	
	public IdeaDAOImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}
	
	public List<Idea> getIdeas() {
		return em.createQuery("Select i from Idea i", Idea.class).getResultList();
	}

	
	
	
}
