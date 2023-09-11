package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
class InterfaceCollectionMedicamentTest {	
	
	@Autowired
    private InterfaceCollectionMedicament collectionMedicament;

	@Test
	void test() {
		Date data = new Date();
		long qtdMedicament = collectionMedicament.count();
		Pet pet = new Pet("Thiago", "masculino", "pinscher", "cachorro", data, true);
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Tutor tutor = new Tutor("Yasmin", "12345678910", "masculino", data, true);
        Address address = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("yasmin@gmail.com", "password");
        NumberPhone phone = new NumberPhone(87, 934345678);
		Diagnosis diagnosis = new Diagnosis("coração acelerado", "ansiedade", "rivotril", "teste");
		Treatment treatment = new Treatment(data, "posologia", "comentário");
		Medicament medicament = new Medicament("rivotril", "ansiolitico", "clonazepam", 20, "use com moderação");
        tutor.setUsuario(userTutor);
        tutor.setAddress(address);
        tutor.setNumberPhone(phone);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        diagnosis.setPet(pet);
		treatment.setDiagnosis(diagnosis);
        collectionMedicament.save(medicament);
        long qtdMedicament2 = collectionMedicament.count();
        assertEquals(qtdMedicament + 1, qtdMedicament2);
	}
}