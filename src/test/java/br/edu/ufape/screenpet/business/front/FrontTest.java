package br.edu.ufape.screenpet.business.front;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FrontTest {
	
	@Autowired
	private Front front;
	
	@BeforeEach
	public void init() throws DuplicateUserException, DoesNotExistUserException {
		Usuario user1 = new Usuario("igor@gmail.com", "9875689");
		Usuario user2 = new Usuario("medeiros@gmail.com", "9875689");
		
		front.saveUsuario(user1);
		front.saveUsuario(user2);
	}
}