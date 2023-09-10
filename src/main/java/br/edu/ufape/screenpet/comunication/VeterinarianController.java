package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVeterinarianException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;

@RestController
@RequestMapping("/api/v14")
public class VeterinarianController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/veterinario")
	public List<Veterinarian> listVeterinarian() {
		return front.listVeterinarian();
	}
	
	@PostMapping("/veterinario")
	public Veterinarian registerVeterinarian(@RequestBody Veterinarian veterinarian) throws DuplicateVeterinarianException, DoesNotExistVeterinarianException {
		return front.saveVeterinarian(veterinarian);
	}
	
	@GetMapping("/veterinario/{id}")
	public Veterinarian printVeterinarian(@PathVariable long id) {
		return front.findVeterinarianId(id);
	}
	
	@PatchMapping("/veterinario/{id}")
	public Veterinarian updateVeterinarian(@PathVariable long id, @RequestBody Veterinarian veterinarian) throws DuplicateVeterinarianException, DoesNotExistVeterinarianException {
		veterinarian.setId(id);
		return front.saveVeterinarian(veterinarian);
	}

	@DeleteMapping("/veterinario/{crmv}")
	public String deleteVeterinarian(@PathVariable int crmv) throws DoesNotExistVeterinarianException {	
		 front.removeVeterinarian(crmv);
		 return "veterinário deletado!";
	}
}