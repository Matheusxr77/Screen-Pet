package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
@ActiveProfiles("test")
class InterfaceCollectionExamTest {
	
	@Autowired
    private InterfaceCollectionExam collectionExam;

    @Test
    void test() {
    	Date data = new Date();
        long qtdExam = collectionExam.count();
        Pet pet = new Pet("Alerreandro", "masculino", "pug", "cachorro", data, true);
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Tutor tutor = new Tutor("Emanoel", "12345678910", "masculino", data, true);
        Address address = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("emanoel@gmail.com", "password", true);
        NumberPhone phone = new NumberPhone(87, 934345678);
        Exam exam = new Exam("Laboc", data, "sanguíneo", "comentarios");
        userTutor.setAddress(address);
        userTutor.setNumberPhone(phone);
        tutor.setUsuario(userTutor);
        tutor.setAddress(address);
        tutor.setNumberPhone(phone);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        exam.setPet(pet);
        collectionExam.save(exam);
        long qtdExam2 = collectionExam.count();
        assertEquals(qtdExam + 1, qtdExam2);
    }
}