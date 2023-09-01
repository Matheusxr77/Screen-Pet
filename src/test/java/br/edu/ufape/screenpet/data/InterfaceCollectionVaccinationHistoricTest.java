package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;

@SpringBootTest
class InterfaceCollectionVaccinationHistoricTest {
    
	@Autowired
    private InterfaceCollectionVaccinationHistoric collectionVaccinationHistoric;
    
    @Test
    void test() {
        long qtdVaccinationHistoric = collectionVaccinationHistoric.count();
        Date data = new Date();
        Vaccine vaccine = new Vaccine("antirabica", "antiviral", 2, "vezes ao dia, durante 3 dias");
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        VaccinationHistoric vaccinationHistoric = new VaccinationHistoric("Histórico de Jubileu");
        vaccinationHistoric.setVaccine(vaccine);
        vaccinationHistoric.setVaccinationCalendar(vaccinationCalendar);
        collectionVaccinationHistoric.save(vaccinationHistoric);
        long qtdVaccinationHistoric2 = collectionVaccinationHistoric.count();
        assertEquals(qtdVaccinationHistoric + 1, qtdVaccinationHistoric2);
    }
}