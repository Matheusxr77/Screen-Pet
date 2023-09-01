package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.Pet;


@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionVeterinarianTest {

    @Autowired
    private InterfaceCollectionVeterinarian collectionVeterinarian;

    @Test
    void test() {
        long qtdVeterinarian = collectionVeterinarian.count();
        Date data = new Date();
        VaccinationCalendar vaccinationCalendar = new VaccinationCalendar(data, data);
        Tutor tutor = new Tutor("Mayara", "12345678910", "feminino", data, true);
        Address addressTutor = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("mayara@gmail.com", "password");
        NumberPhone phoneTutor = new NumberPhone(87, 934345678);
        Pet pet = new Pet("Bela", "feminino", "pinscher", "cachorro", data, true);
        Veterinarian veterinarian = new Veterinarian("Yasmin", "12345678910", "faminino", data, true, 123);
        Address addressVeterinarian = new Address(55299497, "rua de testei", 666, "bairro", "garanhuns", "pe");
        Usuario userVeterinarian = new Usuario("yasmin@gmail.com", "password");
        NumberPhone phoneVeterinarian = new NumberPhone(87, 934345678);
        List<Schedule> scheduleList = new ArrayList<>();
        Schedule schedule1 = new Schedule(LocalTime.now(), "consulta1", data);
        Schedule schedule2 = new Schedule(LocalTime.now(), "consulta2", data);
        scheduleList.add(schedule1);
        scheduleList.add(schedule2);
        schedule1.setPet(pet);
        schedule2.setPet(pet);
        tutor.setUsuario(userTutor);
        tutor.setAddress(addressTutor);
        tutor.setNumberPhone(phoneTutor);
        pet.setTutor(tutor);
        pet.setVaccinationCalendar(vaccinationCalendar);
        veterinarian.setUsuario(userVeterinarian);
        veterinarian.setAddress(addressVeterinarian);
        veterinarian.setNumberPhone(phoneVeterinarian);
        veterinarian.setSchedules(scheduleList);
        collectionVeterinarian.save(veterinarian);
        long qtdVeterinarian2 = collectionVeterinarian.count();
        assertEquals(qtdVeterinarian + 1, qtdVeterinarian2);
    }
}