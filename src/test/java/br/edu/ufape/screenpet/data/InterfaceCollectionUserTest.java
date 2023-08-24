package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.User;

@SpringBootTest
public class InterfaceCollectionUserTest {

	@Autowired
	private InterfaceCollectionUser collectionUser;

	@Test
	void cadastrarTest() {
		long qtdUsuario = collectionUser.count();
		User u = new User(10/04/2004, "adm@gmail.com", "123456789");
		Address a = new Address(12345789, 0, "rua x", 12, "bairro", "gus", "pe");
		u.setAddress(a);
		
		collectionUser.save(u);
		long qtdUsuario2 = collectionUser.count();
		
		assertEquals(qtdUsuario + 1, qtdUsuario2);
	}
}