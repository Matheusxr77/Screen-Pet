package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.basic.NumberPhone;
import br.edu.ufape.screenpet.business.basic.Usuario;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionVeterinarianTest {

    @Autowired
    private InterfaceCollectionVeterinarian collectionVeterinarian;

    @Test
    void test() {
        long qtdVeterinarian = collectionVeterinarian.count();
        Date data = new Date();
        Veterinarian a = new Veterinarian("igor", "12345678910", "masculino", data, true, 123);
        Address add = new Address(55299497, "rua de teste", 666, "bairro", "garanhuns", "pe");
        Usuario u = new Usuario("veterinario@gmail.com", "password", true);
        NumberPhone tel = new NumberPhone(87, 912345678);
        a.setAddress(add);
        a.setUsuario(u);
        a.setNumberPhone(tel);
        collectionVeterinarian.save(a);
        long qtdVeterinarian2 = collectionVeterinarian.count();
        assertEquals(qtdVeterinarian + 1, qtdVeterinarian2);
    }
}