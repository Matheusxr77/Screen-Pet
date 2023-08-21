package br.edu.ufape.screenpet.business.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionUser;
import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.UserNotExistsException;

@Service
public class RegisterUser implements InterfaceRegisterUser {
	@Autowired
	private InterfaceCollectionUser collectionUser;
	
	public User findByEmail(String email) throws UserNotExistsException {
		User u = collectionUser.findByEmail(email); 
		if(u == null) {
			throw new UserNotExistsException(email);
		}
		return u;
	}
	
}
