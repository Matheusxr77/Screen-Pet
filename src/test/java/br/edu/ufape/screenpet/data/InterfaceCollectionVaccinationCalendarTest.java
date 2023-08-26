package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
class InterfaceCollectionVaccinationCalendarTest {
	
	@Autowired
    private InterfaceCollectionVaccinationCalendar collectionVC;

	@Test
	void test() {
		long qtdVC = collectionVC.count();
		Date data = new Date();
		Date frequencia = new Date();
        VaccinationCalendar vc = new VaccinationCalendar(data, frequencia);
        collectionVC.save(vc);
        long qtdVC2 = collectionVC.count();
        assertEquals(qtdVC + 1, qtdVC2);
	}
}