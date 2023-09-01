package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Usuario;
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
        Pet pet = new Pet ("jef", "masc", "vira lata", "cachorro", data, true);
        Veterinarian vet = new Veterinarian("igor", "12345678910", "masculino", data, true, 123);
        Address add = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario u = new Usuario("veterinario@gmail.com", "password", true);
        NumberPhone tel = new NumberPhone(87, 912345678);
        List<Schedule> scheduleList = new ArrayList<>();
        Schedule schedule1 = new Schedule(data, "consulta1", data);
        Schedule schedule2 = new Schedule(data, "consulta2", data);
        scheduleList.add(schedule1);
        scheduleList.add(schedule2);
        vet.setSchedules(scheduleList);
        schedule1.setPet(pet);
        schedule2.setPet(pet);
        u.setAddress(add);
        u.setNumberPhone(tel);
        vet.setAddress(add);
        vet.setUsuario(u);
        vet.setNumberPhone(tel);
        collectionVeterinarian.save(vet);
        long qtdVeterinarian2 = collectionVeterinarian.count();
        assertEquals(qtdVeterinarian + 1, qtdVeterinarian2);
    }
}