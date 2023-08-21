package br.edu.ufape.screenpet.business.register;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionUser;
import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.UserNotExistsException;
import br.edu.ufape.screenpet.business.register.exception.UserDuplicateException;

@Service
public class RegisterUser implements InterfaceRegisterUser {
	@Autowired
	private InterfaceCollectionUser collectionUser;
	
	public User findUserEmail(String email) throws UserNotExistsException {
		User u = collectionUser.findByEmail(email); 
		if(u == null) {
			throw new UserNotExistsException(email);
		}
		return u;
	}
	
	public User saveUser(User entity) throws UserDuplicateException {
		try {
			findUserEmail(entity.getEmail());
			throw new UserDuplicateException(entity.getEmail());
		} catch(UserNotExistsException err) {
			return collectionUser.save(entity);
		}
	}
	
	public User updateUser(User entity) throws UserNotExistsException {
		try {
			findUserEmail(entity.getEmail());
			return collectionUser.save(entity);
		} catch(UserNotExistsException err) {
			throw new UserNotExistsException(entity.getEmail());
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
	
	public void removeUserEmail(String email) throws UserNotExistsException {
		User u = findUserEmail(email);
		collectionUser.delete(u);
	}
	
	public void removeUserId(Long id) throws UserNotExistsException {
		User u = findUserId(id);
		collectionUser.delete(u);
	}
}