package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAppointmentException;

@SpringBootTest
@ActiveProfiles("test") 
class RegisterAppointmentTest {

	@Autowired
	private InterfaceRegisterAppointment registerAppointment;
	
	@Test
	void testRegisterDuplicateAppointment() {
		Date date = new Date();	
		Appointment appointment1 = new Appointment("consulta1", date);
		Appointment appointment2 = new Appointment("consulta2", date);
		
		DuplicateAppointmentException exception = assertThrows(DuplicateAppointmentException.class, () -> {
			registerAppointment.saveAppointment(appointment1);
			registerAppointment.saveAppointment(appointment2);
			}			
		);
		
		assertEquals(exception.getDate(), date);
		assertFalse(exception.getMessage().contains("Apresentam o mesmo horário e data de consulta!"));
	}
}