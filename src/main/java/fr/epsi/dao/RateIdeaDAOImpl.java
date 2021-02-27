package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Idea;
import fr.epsi.entite.RateIdea;

public class RateIdeaDAOImpl implements RateIdeaDAO {
	
	EntityManager em;
	UserTransaction utx;
	
	public RateIdeaDAOImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}

	public List<RateIdea> getRateIdea(Idea idea) {
		return em.createQuery("Select r from RateIdea r where r.idea=:idea", RateIdea.class)
				.setParameter("idea", idea)
				.getResultList();
	}

}
