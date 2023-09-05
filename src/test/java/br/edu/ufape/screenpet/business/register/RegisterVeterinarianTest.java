package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;

@SpringBootTest
@ActiveProfiles("test")
public class RegisterVeterinarianTest {

	@Autowired
	private InterfaceRegisterVeterinarian registerVeterinarian;
	
	@Test
	void testRegisterDuplicateVeterinarian() {
		int crmv = 12345;
		Date date = new Date();	
		Veterinarian veterinarian1 = new Veterinarian("veterinarian1", "1231231231", "feminino", date, true, crmv);
		Veterinarian veterinarian2 = new Veterinarian("veterinarian", "1478237827", "masculino", date, true, crmv);
		
		DuplicateVeterinarianException exception = assertThrows(DuplicateVeterinarianException.class, () -> {
			registerVeterinarian.saveVeterinarian(veterinarian1);
			registerVeterinarian.saveVeterinarian(veterinarian2);
			}			
		);
		
		assertEquals(exception.getCrmv(), crmv);
		assertFalse(exception.getMessage().contains("Apresentam o mesmo crmv!"));
	}
}