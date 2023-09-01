package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Usuario;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionTutorTest {

    @Autowired
    private InterfaceCollectionTutor collectionTutor;

    @Test
    void test() {
        long qtdTutor = collectionTutor.count();
        Date data = new Date();
        Tutor tutor = new Tutor("Alan", "12345678910", "masculino", data, true);
        Address address = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario userTutor = new Usuario("alan@gmail.com", "password");
        NumberPhone phone = new NumberPhone(87, 912345678);
        tutor.setAddress(address);
        tutor.setUsuario(userTutor);
        tutor.setNumberPhone(phone);
        collectionTutor.save(tutor);
        long qtdTutor2 = collectionTutor.count();
        assertEquals(qtdTutor + 1, qtdTutor2);
    }
}