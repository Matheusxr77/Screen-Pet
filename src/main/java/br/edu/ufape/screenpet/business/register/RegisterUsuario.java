package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionUser;
import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.DisabledUserException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

@Service
public class RegisterUser implements InterfaceRegisterUser {
	@Autowired
	private InterfaceCollectionUser collectionUser;
	
	public User findUserEmail(String email) throws DoesNotExistUserException {
		User u = collectionUser.findByEmail(email); 
		if(u == null) {
			throw new DoesNotExistUserException(email);
		}
		return u;
	}
	
	public User saveUser(User entity) throws DuplicateUserException {
		try {
			findUserEmail(entity.getEmail());
			throw new DuplicateUserException(entity.getEmail());
		} catch(DoesNotExistUserException err) {
			return collectionUser.save(entity);
		}
	}
	
	public List<User> listUsers() {
		return collectionUser.findAll();
	}
	
	public boolean checkUserExistence(Long id) {
		return collectionUser.existsById(id);
	}
	
	public User findUserId(Long id) {
		return collectionUser.findById(id).orElse(null);
	}
	
	public void deactivateUser(Long id) throws DoesNotExistUserException, DisabledUserException {
		User u = findUserId(id);
		u.setActive(false);
	}
}