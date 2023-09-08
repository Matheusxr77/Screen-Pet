package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAttendantException;

@SpringBootTest
@ActiveProfiles("test") 
class RegisterAttendantTest {
	
	@Autowired
	private InterfaceRegisterAttendant registerAttendant;
	
	@Test
	void testRegisterDuplicateAttendant() {
		String cpf = "12345678910";
		Date date = new Date();	
		Attendant attendant1 = new Attendant("atendente1", cpf, "feminino", date, true);
		Attendant attendant2 = new Attendant("atendente2", cpf, "masculino", date, true);
		
		DuplicateAttendantException exception = assertThrows(DuplicateAttendantException.class, () -> {
			registerAttendant.saveAttendant(attendant1);
			registerAttendant.saveAttendant(attendant2);
			}			
		);
		
		assertEquals(exception.getCpf(), cpf);
		assertFalse(exception.getMessage().contains("Apresentam o mesmo cpf!"));
	}
}