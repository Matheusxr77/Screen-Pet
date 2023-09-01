package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.edu.ufape.screenpet.business.basic.Usuario;

@SpringBootTest
@ActiveProfiles("test") 
class InterfaceCollectionUsuarioTest {

    @Autowired
    private InterfaceCollectionUsuario collectionUsuario;
    
    @Test
    void test() {
        long qtdUsuario = collectionUsuario.count();
        Usuario user = new Usuario("carlao@gmail.com", "1233454");
        collectionUsuario.save(user);
        long qtdUsuario2 = collectionUsuario.count();
        assertEquals(qtdUsuario + 1, qtdUsuario2);
    }
}