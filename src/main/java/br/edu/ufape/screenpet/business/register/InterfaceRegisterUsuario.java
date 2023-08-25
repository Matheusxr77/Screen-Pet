package br.edu.ufape.screenpet.business.register;

import java.util.List;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.register.exception.DisabledUserException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

public interface InterfaceRegisterUsuario {
	Usuario findUsuarioEmail(String email) throws DoesNotExistUserException;
	Usuario saveUsuario(Usuario entity) throws DuplicateUserException;
	List<Usuario> listUsuarios();
	boolean checkUsuarioExistence(Long id);
	Usuario findUsuarioId(Long id);
	void deactivateUsuario(Long id) throws DoesNotExistUserException, DisabledUserException;
}