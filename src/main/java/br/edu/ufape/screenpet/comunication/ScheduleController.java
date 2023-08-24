package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistPetException;
import br.edu.ufape.screenpet.business.register.exception.DuplicatePetException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@RequestMapping("/api/v5")
public class ScheduleController {
	@Autowired
	public Front front;
	
	@GetMapping("/pet")
	public List<Pet> listPets() {
		return front.listPets();
	}
	
	@PostMapping("/pet")
	public Pet registerPet(@RequestBody Pet pet) throws DuplicatePetException, DoesNotExistPetException {
		return front.savePet(pet);
	}
	
	@GetMapping("/pet/{id}")
	public Pet printPet(@PathVariable long id) {
		return front.findPetId(id);
	}
	
	@PatchMapping("/pet/{id}")
	public Pet updatePet(@PathVariable String name, @RequestBody Pet pet) throws DuplicatePetException {
		pet.setName(name);
		return front.savePet(pet);
	}
}