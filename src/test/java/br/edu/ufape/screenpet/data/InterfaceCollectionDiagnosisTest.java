package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Diagnosis;

@SpringBootTest
class InterfaceCollectionDiagnosisTest {
	@Autowired
    private InterfaceCollectionDiagnosis collectionDiagnosis;

    @Test
    void test() {
    	Date data = new Date();
        long qtdDiagnosis = collectionDiagnosis.count();
        Pet pet = new Pet("Trava", "masculino", "pinscher", "cachorro", data, true);
        Diagnosis diagnosis = new Diagnosis("sintomas", "patologia", "prescrição", "comentarios");
        diagnosis.setPet(pet);
        collectionDiagnosis.save(diagnosis);
        long qtdDiagnosis2 = collectionDiagnosis.count();
        assertEquals(qtdDiagnosis + 1, qtdDiagnosis2);
    }
}