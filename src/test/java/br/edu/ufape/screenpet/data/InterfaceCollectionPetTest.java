package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Pet;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionPetTest {

	@Autowired
    private InterfaceCollectionPet collectionPet;

    @Test
    void test() {
        long qtdPet = collectionPet.count();
        Date data = new Date();
        Pet pet = new Pet("Jefferson", "masculino", "pinscher", "cachorro", data, true);
        collectionPet.save(pet);
        long qtdPet2 = collectionPet.count();
        assertEquals(qtdPet + 1, qtdPet2);
    }
}