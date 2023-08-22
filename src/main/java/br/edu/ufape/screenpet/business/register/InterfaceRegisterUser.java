package br.edu.ufape.screenpet.business.register;

import java.util.List;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.UserNotExistsException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

public interface InterfaceRegisterUser {
	User findUserEmail(String email) throws UserNotExistsException;
	User saveUser(User entity) throws DuplicateUserException;
	User updateUser(User entity) throws UserNotExistsException;
	List<User> listUsers();
	boolean checkUserExistence(Long id);
	User findUserId(Long id);
	void removeUserEmail(String email) throws UserNotExistsException;
	void removeUserId(Long id) throws UserNotExistsException;
}