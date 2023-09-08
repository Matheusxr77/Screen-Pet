package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationCalendarException;

@SpringBootTest
@ActiveProfiles("test")
class RegisterVaccinationCalendarTest {
	
	@Autowired
	private InterfaceRegisterVaccinationCalendar registerVaccinationCalendar;
	
	@Test
	void testRegisterDuplicateVaccinationCalendar() {
		Date date = new Date();	
		VaccinationCalendar vaccinationCalendar1 = new VaccinationCalendar(date, date);
		VaccinationCalendar vaccinationCalendar2 = new VaccinationCalendar(date, date);
		
		DuplicateVaccinationCalendarException exception = assertThrows(DuplicateVaccinationCalendarException.class, () -> {
			registerVaccinationCalendar.saveVaccinationCalendar(vaccinationCalendar1);
			registerVaccinationCalendar.saveVaccinationCalendar(vaccinationCalendar2);
			}			
		);
		
		assertEquals(exception.getDate(), date);
		assertFalse(exception.getMessage().contains("Apresentam o mesmo horário e data do calendário de vacinação!"));
	}
}