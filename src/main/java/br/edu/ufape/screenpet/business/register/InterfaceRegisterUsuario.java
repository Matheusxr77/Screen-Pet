package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.DisabledUserException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

public interface InterfaceRegisterUser {
	User findUserEmail(String email) throws DoesNotExistUserException;
	User saveUser(User entity) throws DuplicateUserException;
	List<User> listUsers();
	boolean checkUserExistence(Long id);
	User findUserId(Long id);
	void deactivateUser(Long id) throws DoesNotExistUserException, DisabledUserException;
}