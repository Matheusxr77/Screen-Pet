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
    private InterfaceCollectionVaccinationHistoric collectionVH;
    
    @Autowired
    private InterfaceCollectionVaccinationCalendar collectionVC;

    @Test
    void test() {
        long qtdVH = collectionVH.count();
        VaccinationCalendar vc = new VaccinationCalendar(new Date(), new Date());
        collectionVC.save(vc);
        VaccinationHistoric vh = new VaccinationHistoric("help");
        vh.setVaccinationCalendar(vc);
        collectionVH.save(vh);
        long qtdVH2 = collectionVH.count();
        assertEquals(qtdVH + 1, qtdVH2);
    }
}
