package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.NumberPhone;

@SpringBootTest
@ActiveProfiles("test")
class InterfaceCollectionDiagnosisTest {
	
	@Autowired
    private InterfaceCollectionDiagnosis collectionDiagnosis;

    @Test
    void test() {
    	Date data = new Date();
        long qtdDiagnosis = collectionDiagnosis.count();
        Pet pet = new Pet("Trava", "masculino", "pinscher", "cachorro", data, true);
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Tutor tutor = new Tutor("Lucas", "12345678910", "masculino", data, true);
        Address address = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("lucas@gmail.com", "password", true);
        NumberPhone phone = new NumberPhone(87, 934345678);
        Diagnosis diagnosis = new Diagnosis("sintomas", "patologia", "prescrição", "comentarios");
        userTutor.setAddress(address);
        userTutor.setNumberPhone(phone);
        tutor.setUsuario(userTutor);
        tutor.setAddress(address);
        tutor.setNumberPhone(phone);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        diagnosis.setPet(pet);
        collectionDiagnosis.save(diagnosis);
        long qtdDiagnosis2 = collectionDiagnosis.count();
        assertEquals(qtdDiagnosis + 1, qtdDiagnosis2);
    }
}