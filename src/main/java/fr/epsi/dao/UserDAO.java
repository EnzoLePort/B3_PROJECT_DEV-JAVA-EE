package fr.epsi.dao;

import fr.epsi.entite.User;

public interface UserDAO {
	
	User get(String email, String password);

}
