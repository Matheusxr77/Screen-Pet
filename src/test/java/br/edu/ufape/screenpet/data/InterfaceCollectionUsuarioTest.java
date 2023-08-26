package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Address;
import br.edu.ufape.screenpet.business.basic.Usuario;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionUsuarioTest {

    @Autowired
    private InterfaceCollectionUsuario collectionUsuario;
    
    @Test
    void test() {
        long qtdUsuario = collectionUsuario.count();
        Usuario u = new Usuario("teste@gmail.com", "65412", true);
        Address a = new Address(55299497, "rua xv", 5,  "bairro", "garanhuns", "pe");
        u.setAddress(a);
        collectionUsuario.save(u);
        long qtdUsuario2 = collectionUsuario.count();
        assertEquals(qtdUsuario + 1, qtdUsuario2);
    }
}