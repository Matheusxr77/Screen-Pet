package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.basic.Pet;

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
        Exam exam = new Exam("Laboc", data, "sanguíneo", "comentarios");
        exam.setPet(pet);
        collectionExam.save(exam);
        long qtdExam2 = collectionExam.count();
        assertEquals(qtdExam + 1, qtdExam2);
    }
}