package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
class InterfaceCollectionTreatmentTest {
    
    @Autowired
    private InterfaceCollectionTreatment collectionTreatment;

    @Test
    void test() {
        long qtdTreatment = collectionTreatment.count();
        Date data = new Date();
        Pet pet = new Pet("Rubens", "masculino", "pinscher", "cachorro", data, true);
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Tutor tutor = new Tutor("Rodolfo", "12345678910", "masculino", data, true);
        Address address = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("rodolfo@gmail.com", "password");
        NumberPhone phone = new NumberPhone(87, 934345678);
        Diagnosis diagnosis = new Diagnosis("coração acelerado", "ansiedade", "rivotril", "teste");
        Treatment treatment = new Treatment(data, "teste (posologia)", "comentário");
        tutor.setUsuario(userTutor);
        tutor.setAddress(address);
        tutor.setNumberPhone(phone);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        diagnosis.setPet(pet);
        treatment.setDiagnosis(diagnosis);
        collectionTreatment.save(treatment);
        long qtdTreatment2 = collectionTreatment.count();
        assertEquals(qtdTreatment + 1, qtdTreatment2);
    }
}