package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.screenpet.business.basic.Medicament;


@SpringBootTest
class InterfaceCollectionMedicamentTest {
	
	@Autowired
    private InterfaceCollectionMedicament collectionMed;

	@Test
	void test() {
		long qtdMed = collectionMed.count();
        Medicament med = new Medicament("rivotril", "ansiolitico", "clonazepam", 20, "use com moderação");
        collectionMed.save(med);
        long qtdMed2 = collectionMed.count();
        assertEquals(qtdMed + 1, qtdMed2);
	}
}