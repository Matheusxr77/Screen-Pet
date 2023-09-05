package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccineException;

@SpringBootTest
@ActiveProfiles("test") 
class RegisterVaccineTest {
	
	@Autowired
	private InterfaceRegisterVaccine registerVaccine;
	
	@Test
	void testRegisterDuplicateVaccine() {
		String name = "injeção";
		Vaccine vaccine1 = new Vaccine(name, "tipo1", 4, "durante quatro dias");
		Vaccine vaccine2 = new Vaccine(name, "tipo2", 4, "durante quatro dias");
		
		DuplicateVaccineException exception = assertThrows(DuplicateVaccineException.class, () -> {
			registerVaccine.saveVaccine(vaccine1);
			registerVaccine.saveVaccine(vaccine2);
			}			
		);
		
		assertEquals(exception.getName(), name);
		assertFalse(exception.getMessage().contains("Apresentam o mesmo nome!"));
	}
}