package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.Veterinarian;

@SpringBootTest
class InterfaceCollectionAppointmentTest {

    @Autowired
    private InterfaceCollectionAppointment collectionAppointment;

    @Test
    void test() {
        long qtdAppointment = collectionAppointment.count();
        Date data = new Date();
        Pet pet = new Pet("pet", "indefinido", data, true);
        Veterinarian vet = new Veterinarian("igor", "12345678910", "masculino", data, true, 123);
        Address add = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario u = new Usuario("veterinario@gmail.com", "password", true);
        NumberPhone tel = new NumberPhone(87, 912345678);
        Schedule s = new Schedule(data, "tipo", data);
        Appointment a = new Appointment("anamnese", data);
        vet.setAddress(add);
        vet.setNumberPhone(tel);
        vet.setUsuario(u);
        s.setPet(pet);
        a.setSchedule(s);
        a.setPet(pet);
        vet.setAppointment(a);
        collectionAppointment.save(a);
        long qtdAppointment2 = collectionAppointment.count();
        assertEquals(qtdAppointment + 1, qtdAppointment2);
    }
}
