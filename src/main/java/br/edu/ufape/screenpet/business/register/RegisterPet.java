package br.edu.ufape.screenpet.business.register;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionPet;
import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.InvalidBirthdatePetException;
import br.edu.ufape.screenpet.business.register.exception.PetNotExistsException;
import br.edu.ufape.screenpet.business.register.exception.PetDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.PetNotExistsException;

@Service
public class RegisterPet implements InterfaceRegisterPet {
	@Autowired
	private InterfaceCollectionPet collectionPet;
	
	public Pet findPetName(String name) throws PetNotExistsException {
		Pet p = collectionPet.findPetName(name); 
		if(p == null) {
			throw new PetNotExistsException(name);
		}
		return p;
	}
	
	public Pet savePet(Pet entity) throws PetDuplicateException {
		try {
			findPetName(entity.getName());
			throw new PetDuplicateException(entity.getName());
		} catch(PetNotExistsException err) {
			return collectionPet.save(entity);
		}
	}
	
	public Pet updatePet(Pet entity) throws PetNotExistsException {
		try {
			findPetName(entity.getName());
			return collectionPet.save(entity);
		} catch(PetNotExistsException err) {
			throw new PetNotExistsException(entity.getName());
		}
	}
	
	public List<Pet> listPets() {
		return collectionPet.findAll();
	}
	
	public boolean checkPetExistence(Long id) {
		return collectionPet.existsById(id);
	}
	
	public Pet findPetId(Long id) {
		return collectionPet.findById(id).orElse(null);
	}
	
	public void removePetId(Long id) throws PetNotExistsException {
		Pet u = findPetId(id);
		collectionPet.delete(u);
	}
}
