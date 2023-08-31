package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;

@SpringBootTest
class InterfaceCollectionVaccinationHistoricTest {
    
	@Autowired
    private InterfaceCollectionVaccinationHistoric collectionVaccinationHistoric;
    
    @Test
    void test() {
        long qtdVaccinationHistoric = collectionVaccinationHistoric.count();
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(new Date(), new Date());
        VaccinationHistoric vaccinationHistoric = new VaccinationHistoric("ajuda-me");
        vaccinationHistoric.setVaccinationCalendar(vaccinationCalendar);
        collectionVaccinationHistoric.save(vaccinationHistoric);
        long qtdVaccinationHistoric2 = collectionVaccinationHistoric.count();
        assertEquals(qtdVaccinationHistoric + 1, qtdVaccinationHistoric2);
    }
}