package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.DisabledUserException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

public interface InterfaceRegisterUser {
	User findUserEmail(String email) throws DoesNotExistUserException;
	User saveUser(User entity) throws DuplicateUserException;
	User updateUser(User entity) throws DoesNotExistUserException;
	List<User> listUsers();
	boolean checkUserExistence(Long id);
	User findUserId(Long id);
	void removeUserEmail(String email) throws DoesNotExistUserException;
	void removeUserId(Long id) throws DoesNotExistUserException;
	void deactivateUser(String email) throws DoesNotExistUserException, DisabledUserException;
}