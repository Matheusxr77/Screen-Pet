package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//import br.edu.ufape.screenpet.business.basic.Address;
//import br.edu.ufape.screenpet.business.basic.Attendant;
//import br.edu.ufape.screenpet.business.basic.Usuario;

class InterfaceCollectionAttendantTest {
	
	 @Autowired
	   private InterfaceCollectionAttendant collectionAttendant;

	@Test
	void test() {
		long qtdAttendant = collectionAttendant.count();
        //Attendant a = new Attendant();
        //Address add = new Address(55299497, "rua de teste", 666,  "bairro", "garanhuns", "pe");
        //a.setAddress(add);
        //collectionAttendant.save(a);
        long qtdAttendant2 = collectionAttendant.count();
        assertEquals(qtdAttendant + 1, qtdAttendant2);
		
	}

}
