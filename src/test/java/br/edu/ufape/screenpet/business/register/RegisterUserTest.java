package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;

@SpringBootTest
class RegisterUserTest {
	
	@Autowired
	private InterfaceRegisterUser registerUser;


	@Test
	void testRegisterDuplicateUser() {
		String email = "test@gmail.com";	
		User u1 = new User(1, email, "senha123");
		User u2 = new User(2, email, "123senha");
		
		DuplicateUserException exception = 
				assertThrows(DuplicateUserException.class, 
			() -> {
				registerUser.saveUser(u1);
				registerUser.saveUser(u2);
				  }			
		);
		assertEquals(exception.getEmail(), email);
		assertTrue(exception.getMessage().contains("Mesmo email!"));
	}
}