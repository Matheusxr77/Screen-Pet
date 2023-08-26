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
        Tutor a = new Tutor("Jeff", "12345678910", "masculino", data, true);
        Address add = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario u = new Usuario("atendente@gmail.com", "password", true);
        NumberPhone tel = new NumberPhone(87, 912345678);
        u.setAddress(add);
        u.setNumberPhone(tel);
        a.setAddress(add);
        a.setUsuario(u);
        a.setNumberPhone(tel);
        collectionTutor.save(a);
        long qtdTutor2 = collectionTutor.count();
        assertEquals(qtdTutor + 1, qtdTutor2);
    }
}