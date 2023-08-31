package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Exam;
import br.edu.ufape.screenpet.business.basic.Veterinarian;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionAppointmentTest {
	
    @Autowired
    private InterfaceCollectionAppointment collectionAppointment;

    @Test
    void test() {
        long qtdAppointment = collectionAppointment.count();
        Date data = new Date();
        Pet pet = new Pet("pet", "indefinido", "labrador", "cachorro", data, true);
        VaccinationCalendar vc = new VaccinationCalendar(new Date(), new Date());
        VaccinationHistoric vh = new VaccinationHistoric("socorro");
        Veterinarian vet = new Veterinarian("matheus", "22345678910", "masculino", data, true, 321);
        Diagnosis d = new Diagnosis("diarreia", "patologia", "prescrição", "comentarios");
        Address add = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario u = new Usuario("matheus@gmail.com", "password", true);
        NumberPhone tel = new NumberPhone(87, 912345678);
        Schedule s = new Schedule(data, "rotineira", data);
        Appointment a = new Appointment("anamnese", data);
        List<Exam> examList = new ArrayList<>();
        Exam exam1 = new Exam("Blood Test", data, "urgencia", "sucesso");
        Exam exam2 = new Exam("X-Ray", data, "urgencia", "sucesso");
        examList.add(exam1);
        examList.add(exam2);
        a.setExams(examList);
        u.setAddress(add);
        u.setNumberPhone(tel);
        vet.setUsuario(u);
        vet.setAddress(add);
        vet.setNumberPhone(tel);
        s.setPet(pet);
        vh.setVaccinationCalendar(vc);
        a.setVaccinationHistoric(vh);
        a.setSchedule(s);
        a.setPet(pet);
        a.setVeterinarian(vet);
        a.setDiagnosis(d);
        collectionAppointment.save(a);
        long qtdAppointment2 = collectionAppointment.count();
        assertEquals(qtdAppointment + 1, qtdAppointment2);
    }
}
