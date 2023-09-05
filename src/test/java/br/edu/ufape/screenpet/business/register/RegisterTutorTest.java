package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;

@SpringBootTest
@ActiveProfiles("test")
class RegisterTutorTest {

	@Autowired
	private InterfaceRegisterTutor registerTutor;
	
	@Test
	void testRegisterDuplicateTutor() {
		String cpf = "12345678910";
		Date date = new Date();	
		Tutor tutor1 = new Tutor("tutor1", cpf, "feminino", date, true);
		Tutor tutor2 = new Tutor("tutor2", cpf, "masculino", date, true);
		
		DuplicateTutorException exception = assertThrows(DuplicateTutorException.class, () -> {
			registerTutor.saveTutor(tutor1);
			registerTutor.saveTutor(tutor2);
			}			
		);
		
		assertEquals(exception.getCpf(), cpf);
		assertFalse(exception.getMessage().contains("Apresentam o mesmo cpf!"));
	}
}