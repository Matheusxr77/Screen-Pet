package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccineException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccineException;

@RestController
@RequestMapping("/api/v13")
public class VaccineController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/vacinas")
	public List<Vaccine> listVaccine() {
		return front.listVaccines();
	}
	
	@PostMapping("/vacinas")
	public Vaccine registerVaccine(@RequestBody Vaccine vaccine) throws DuplicateVaccineException, DoesNotExistVaccineException {
		return front.saveVaccine(vaccine);
	}
	
	@GetMapping("/vacinas/{id}")
	public Vaccine printVaccine(@PathVariable long id) {
		return front.findVaccineId(id);
	}
}