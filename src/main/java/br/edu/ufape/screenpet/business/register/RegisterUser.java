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
	
	public User updateUser(User entity) throws DoesNotExistUserException {
		try {
			findUserEmail(entity.getEmail());
			return collectionUser.save(entity);
		} catch(DoesNotExistUserException err) {
			throw new DoesNotExistUserException(entity.getEmail());
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
	
	public void removeUserEmail(String email) throws DoesNotExistUserException {
		User u = findUserEmail(email);
		collectionUser.delete(u);
	}
	
	public void removeUserId(Long id) throws DoesNotExistUserException {
		User u = findUserId(id);
		collectionUser.delete(u);
	}
	
	public void deactivateUser(String email) throws DoesNotExistUserException, DisabledUserException {
		User u = findUserEmail(email);
		u.setActive(false);
	}
}