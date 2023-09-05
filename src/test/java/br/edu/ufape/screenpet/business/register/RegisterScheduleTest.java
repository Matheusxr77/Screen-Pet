package br.edu.ufape.screenpet.business.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.register.exception.DuplicateScheduleException;

@SpringBootTest
@ActiveProfiles("test")
class RegisterScheduleTest {

	@Autowired
	private InterfaceRegisterSchedule registerSchedule;
	
	@Test
	void testRegisterDuplicateVeterinarian() {
		Date date = new Date();	
		LocalTime time = LocalTime.now();
		Schedule schedule1 = new Schedule(time, "rotineira1", date);
		Schedule schedule2 = new Schedule(time, "rotineira2", date);
		
		DuplicateScheduleException exception = assertThrows(DuplicateScheduleException.class, () -> {
			registerSchedule.saveSchedule(schedule1);
			registerSchedule.saveSchedule(schedule2);
			}			
		);
		
		assertEquals(exception.getDate(), date);
		assertFalse(exception.getMessage().contains("Apresentam a mesma data e horário!"));
	}
}