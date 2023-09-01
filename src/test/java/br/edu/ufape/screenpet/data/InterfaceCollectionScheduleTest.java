package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionScheduleTest {

    @Autowired
    private InterfaceCollectionSchedule collectionSchedule;

    @Test
	void test() {
    	long qtdSchedule = collectionSchedule.count();
        Date data = new Date();
        LocalTime time = LocalTime.now();
        Tutor tutor = new Tutor("Ícaro", "12345678910", "masculino", data, true);
        Address address = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("icaro@gmail.com", "password");
        NumberPhone phone = new NumberPhone(87, 912345678);
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Pet pet = new Pet("Igor", "masculino", "pinscher", "cachorro", data, true);
        Schedule schedule = new Schedule(time, "rotineira", data);
        tutor.setAddress(address);
        tutor.setUsuario(userTutor);
        tutor.setNumberPhone(phone);
        pet.setVaccinationCalendar(vaccinationCalendar);
        pet.setTutor(tutor);
        schedule.setPet(pet);
        collectionSchedule.save(schedule);
        long qtdSchedule2 = collectionSchedule.count();
        assertEquals(qtdSchedule + 1, qtdSchedule2);
	}
}