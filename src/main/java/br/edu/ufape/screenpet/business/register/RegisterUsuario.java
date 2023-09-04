package br.edu.ufape.screenpet.business.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionUsuario;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

@Service
public class RegisterUsuario implements InterfaceRegisterUsuario {
	
	@Autowired
	private InterfaceCollectionUsuario collectionUsuario;
	
	public Usuario findUsuarioEmail(String email) throws DoesNotExistUserException {
		Usuario u = collectionUsuario.findByEmail(email); 
		if(u == null) {
			throw new DoesNotExistUserException(email);
		}
		return u;
	}
	
	public Usuario saveUsuario(Usuario entity) throws DuplicateUserException, DoesNotExistUserException {
		try {
			findUsuarioEmail(entity.getEmail());
			throw new DuplicateUserException(entity.getEmail());
		} catch(DoesNotExistUserException err) {
			return collectionUsuario.save(entity);
		}
	}
	
	public List<Usuario> listUsuarios() {
		return collectionUsuario.findAll();
	}
	
	public boolean checkUsuarioExistence(Long id) {
		return collectionUsuario.existsById(id);
	}
	
	public Usuario findUsuarioId(Long id) {
		return collectionUsuario.findById(id).orElse(null);
	}
	
	public void removeUsuarioEmail(String email) throws DoesNotExistUserException {
		Usuario u = findUsuarioEmail(email);
		collectionUsuario.delete(u);
	}
}