package br.edu.ufape.screenpet.business.register;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.UserNotExistsException;

public interface InterfaceRegisterUser {
	User findByEmail(String email) throws UserNotExistsException;
}
