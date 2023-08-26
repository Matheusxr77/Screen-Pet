package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Treatment;

@SpringBootTest
class InterfaceCollectionTreatmentTest {
    
    @Autowired
    private InterfaceCollectionTreatment collectionTreatment;

    @Test
    void test() {
        long qtdTreatment = collectionTreatment.count();
        Date data = new Date();
        Diagnosis diagnosis = new Diagnosis("coração acelerado", "ansiedade", "rivotril", "teste");
        Treatment treatment = new Treatment(data, "teste (posologia)", "comentário");
        treatment.setDiagnosis(diagnosis);
        collectionTreatment.save(treatment);
        long qtdTreatment2 = collectionTreatment.count();
        assertEquals(qtdTreatment + 1, qtdTreatment2);
    }
}