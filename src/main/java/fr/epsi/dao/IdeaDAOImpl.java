package fr.epsi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Idea;
import fr.epsi.entite.Rate;
import fr.epsi.entite.RateIdea;

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

	public void add(Idea idea) {
		try {
			utx.begin();
			em.persist(idea);
			utx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Idea> getTopRatingIdeas() {
		List<Idea> topRatingIdea = new ArrayList<Idea>();
		Rate rate = new Rate();
		rate.setId(Long.parseLong("2"));
//		List<Idea> listIdeasInRateIdea = em.createQuery("SELECT r.idea FROM RateIdea r GROUP BY r.idea", Idea.class).getResultList();
//	    for (Idea ideaInRateIdea : listIdeasInRateIdea) {
//			Long nbTop = (Long) em.createQuery("SELECT COUNT(id) as nbNote,r.idea FROM RateIdea r WHERE r.rate=:rate GROUP BY r.idea ORDER BY nbNote asc")
//								.setParameter("rate", rate)
//								.getSingleResult();
//	    }
//		em.createQuery("SELECT COUNT(id) as nbNote,r.idea FROM RateIdea r WHERE r.rate=:rate GROUP BY r.idea ORDER BY nbNote asc", Idea.class)
//								.setParameter("rate", rate)
//								.getResultList();
		List<Object[]> objects = em.createQuery("SELECT COUNT(r.id) as nbTop, r.idea FROM RateIdea r WHERE r.rate = :rate GROUP BY r.idea ORDER BY nbTop desc")
							.setParameter("rate", rate)
							.getResultList();
		int i = 1;
		for (Object[] object : objects) {
			if(i < 4) {
				Idea idea = (Idea) object[1];
				topRatingIdea.add(idea);
			}
			i++;
		}
		return topRatingIdea;
	}

	
	
	
}
