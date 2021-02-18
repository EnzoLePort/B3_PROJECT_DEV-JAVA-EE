package fr.epsi.service;

import fr.epsi.entite.User;

public interface UserService {
	
	User get(String email, String password);

}
