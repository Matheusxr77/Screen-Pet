package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Usuario;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionAttendantTest {
	
    @Autowired
    private InterfaceCollectionAttendant collectionAttendant;

    @Test
    void test() {
        long qtdAttendant = collectionAttendant.count();
        Date data = new Date();
        Attendant attendant = new Attendant("atendente", "12345678910", "fem", data, true);
        Address address = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario userAttendant = new Usuario("atendente@gmail.com", "password");
        NumberPhone phone = new NumberPhone(87, 912345678);
        attendant.setAddress(address);
        attendant.setUsuario(userAttendant);
        attendant.setNumberPhone(phone);
        collectionAttendant.save(attendant);
        long qtdAttendant2 = collectionAttendant.count();
        assertEquals(qtdAttendant + 1, qtdAttendant2);
    }
}