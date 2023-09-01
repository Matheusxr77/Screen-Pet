package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionPetTest {
	
	@Autowired
    private InterfaceCollectionPet collectionPet;

    @Test
    void test() {
        long qtdPet = collectionPet.count();
        Date data = new Date();
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Tutor tutor = new Tutor("Yasmin", "12345678910", "feminino", data, true);
        Address address = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("yasmin@gmail.com", "password");
        NumberPhone phone = new NumberPhone(87, 934345678);
        Pet pet = new Pet("Luan", "masculino", "pinscher", "cachorro", data, true);
        tutor.setUsuario(userTutor);
        tutor.setAddress(address);
        tutor.setNumberPhone(phone);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        collectionPet.save(pet);
        long qtdPet2 = collectionPet.count();
        assertEquals(qtdPet + 1, qtdPet2);
    }
}