package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.Treatment;

@SpringBootTest
class InterfaceCollectionMedicamentTest {	
	
	@Autowired
    private InterfaceCollectionMedicament collectionMedicament;

	@Test
	void test() {
		Date data = new Date();
		long qtdMedicament = collectionMedicament.count();
		Diagnosis diagnosis = new Diagnosis("coração acelerado", "ansiedade", "rivotril", "teste");
		Treatment treatment = new Treatment(data, "posologia", "comentário");
		treatment.setDiagnosis(diagnosis);
		Medicament medicament = new Medicament("rivotril", "ansiolitico", "clonazepam", 20, "use com moderação");
        medicament.setTreatment(treatment);
        collectionMedicament.save(medicament);
        long qtdMedicament2 = collectionMedicament.count();
        assertEquals(qtdMedicament + 1, qtdMedicament2);
	}
}