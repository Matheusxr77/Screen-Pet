package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
class InterfaceCollectionVaccinationCalendarTest {
	
	@Autowired
    private InterfaceCollectionVaccinationCalendar collectionVaccinationCalendar;

	@Test
	void test() {
		long qtdVaccinationCalendar = collectionVaccinationCalendar.count();
		Date data = new Date();
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        collectionVaccinationCalendar.save(vaccinationCalendar);
        long qtdVaccinationCalendar2 = collectionVaccinationCalendar.count();
        assertEquals(qtdVaccinationCalendar + 1, qtdVaccinationCalendar2);
	}
}