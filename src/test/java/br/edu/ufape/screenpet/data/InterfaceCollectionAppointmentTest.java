package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.time.LocalTime;
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
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.basic.Vaccine;
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
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        VaccinationHistoric vaccinationHistoric = new VaccinationHistoric("socorro");
        Diagnosis diagnosis = new Diagnosis("diarreia", "patologia", "prescrição", "comentarios");
        Veterinarian veterinarian = new Veterinarian("Matheus", "22345678910", "masculino", data, true, 321);
        Address addressVeterinarian = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario userVeterinarian = new Usuario("matheus@gmail.com", "password");
        NumberPhone phoneVeterinarian = new NumberPhone(87, 912345678);
        Tutor tutor = new Tutor("Thiago", "12345678910", "masculino", data, true);
        Address addressTutor = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("thiago@gmail.com", "password");
        NumberPhone phoneTutor = new NumberPhone(87, 934345678);
        Vaccine vaccine = new Vaccine("Vacina", "tipo1", 2, "durante três dias");
        Schedule schedule = new Schedule(LocalTime.now(), "rotineira", data);
        Appointment appointment = new Appointment("anamnese", data);
        List<Exam> examList = new ArrayList<>();
        Exam exam1 = new Exam("Blood Test", data, "urgencia", "sucesso");
        Exam exam2 = new Exam("X-Ray", data, "urgencia", "sucesso");
        examList.add(exam1);
        examList.add(exam2);
        exam1.setPet(pet);
        exam2.setPet(pet);
        diagnosis.setPet(pet);
        veterinarian.setUsuario(userVeterinarian);
        veterinarian.setAddress(addressVeterinarian);
        veterinarian.setNumberPhone(phoneVeterinarian);
        tutor.setUsuario(userTutor);
        tutor.setAddress(addressTutor);
        tutor.setNumberPhone(phoneTutor);
        schedule.setPet(pet);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        vaccinationHistoric.setVaccine(vaccine);
        vaccinationHistoric.setVaccinationCalendar(vaccinationCalendar);
        appointment.setVaccinationHistoric(vaccinationHistoric);
        appointment.setSchedule(schedule);
        appointment.setPet(pet);
        appointment.setVeterinarian(veterinarian);
        appointment.setDiagnosis(diagnosis);
        appointment.setExams(examList);
        collectionAppointment.save(appointment);
        long qtdAppointment2 = collectionAppointment.count();
        assertEquals(qtdAppointment + 1, qtdAppointment2);
    }
}
