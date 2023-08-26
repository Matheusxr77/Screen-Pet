package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Vaccine;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionVaccineTest {

    @Autowired
    private InterfaceCollectionVaccine collectionVaccine;

    @Test
    void test() {
        long qtdVaccine = collectionVaccine.count();
        Vaccine vac = new Vaccine("Vacina", "tipo1", 2, "durante três dias");
        collectionVaccine.save(vac);
        long qtdVaccine2 = collectionVaccine.count();
        assertEquals(qtdVaccine + 1, qtdVaccine2);
    }
}