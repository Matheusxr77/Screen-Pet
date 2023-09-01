package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

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
        Tutor a = new Tutor("Ícaro", "12345678910", "masculino", data, true);
        Address add = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario u = new Usuario("atendente@gmail.com", "password", true);
        NumberPhone tel = new NumberPhone(87, 912345678);
        VaccinationCalendar vc = new VaccinationCalendar(data, data);
        Pet pet = new Pet("Igor", "masculino", "pinscher", "cachorro", data, true);
        Schedule s = new Schedule(data, "rotineira", data);
        u.setAddress(add);
        u.setNumberPhone(tel);
        a.setAddress(add);
        a.setUsuario(u);
        a.setNumberPhone(tel);
        pet.setVaccinationCalendar(vc);
        pet.setTutor(a);
        s.setPet(pet);
        collectionSchedule.save(s);
        long qtdSchedule2 = collectionSchedule.count();
        assertEquals(qtdSchedule + 1, qtdSchedule2);
	}
}