package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@RequestMapping("/api/v10")
public class UsuarioController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/usuario")
	public List<Usuario> listUsuarios() {
		return front.listUsuarios();
	}
	
	@PostMapping("/usuario")
	public Usuario registerUsuario(@RequestBody Usuario usuario) throws DuplicateUserException, DoesNotExistUserException {
		return front.saveUsuario(usuario);
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario printUsuario(@PathVariable long id) {
		return front.findUsuarioId(id);
	}
	
	@PatchMapping("/usuario/{id}")
	public Usuario updateUsuario(@PathVariable String email, @RequestBody Usuario usuario) throws DuplicateUserException, DoesNotExistUserException {
		usuario.setEmail(email);
		return front.saveUsuario(usuario);
	}
	
	@DeleteMapping("/usuario/{email}")
	public String deleteUsuario(@PathVariable String email) throws DoesNotExistUserException {	
		 front.removeUsuario(email);
		 return "usuário deletado!";
	}
}