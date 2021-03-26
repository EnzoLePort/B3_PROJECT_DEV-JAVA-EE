package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idea;
import fr.epsi.entite.User;

public interface UserDAO {
	
	User get(String email);
	
	void subscribe(User user);
	
	List<User> getSubscribeWaiting();
	
	void approveSubscribe(Long id);
	
	
	List<User> getBestRatingUsers();

}
