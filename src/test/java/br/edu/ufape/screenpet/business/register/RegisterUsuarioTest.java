package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

@SpringBootTest
class RegisterUsuarioTest {
	
	@Autowired
	private InterfaceRegisterUsuario registerUsuario;
	
	@Test
	void testRegisterDuplicateUsuario() {
		String email = "teste@gmail.com";	
		Usuario u1 = new Usuario(email, "123senha456");
		Usuario u2 = new Usuario(email, "senha1234");
		
		DuplicateUserException exception = assertThrows(DuplicateUserException.class, () -> {
			registerUsuario.saveUsuario(u1);
			registerUsuario.saveUsuario(u2);
			}			
		);
		assertEquals(exception.getEmail(), email);
		assertFalse(exception.getMessage().contains("Mesmo email!"));
	}
}