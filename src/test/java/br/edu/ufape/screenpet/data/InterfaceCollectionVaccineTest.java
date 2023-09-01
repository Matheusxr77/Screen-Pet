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
        Vaccine vaccine = new Vaccine("Vacina", "tipo", 4, "durante quatro dias");
        collectionVaccine.save(vaccine);
        long qtdVaccine2 = collectionVaccine.count();
        assertEquals(qtdVaccine + 1, qtdVaccine2);
    }
}