package br.edu.ufape.screenpet.business.register;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionPet;
import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.InvalidBirthdatePetException;
import br.edu.ufape.screenpet.business.register.exception.PetNotExistsException;

@Service
public class RegisterPet implements InterfaceRegisterPet {
	@Autowired
	private InterfaceCollectionPet collectionPet;
	
	public Pet findByName(String name) throws PetNotExistsException {
		Pet p = collectionPet.findByName(name); 
		if(p == null) {
			throw new PetNotExistsException(name);
		}
		return p;
	}
}
