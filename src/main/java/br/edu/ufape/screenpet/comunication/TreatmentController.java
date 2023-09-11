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

import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTreatmentException;

@RestController
@RequestMapping("/api/v8")
public class TreatmentController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/tratamento")
	public List<Treatment> listTreatments() {
		return front.listTreatments();
	}
	
	@PostMapping("/tratamento")
	public Treatment registerTreatment(@RequestBody Treatment treatment) throws DoesNotExistTreatmentException {
		return front.saveTreatment(treatment);
	}
	
	@GetMapping("/tratamento/{id}")
	public Treatment printTreatment(@PathVariable long id) {
		return front.findTreatmentId(id);
	}
	
	@PatchMapping("/tratamento/{id}")
	public Treatment updateTreatment(@PathVariable long id, @RequestBody Treatment treatment) throws DoesNotExistTreatmentException {
		treatment.setId(id);
		return front.saveTreatment(treatment);
	}
	
	@DeleteMapping("/tratamento/{id}")
	public String deleteTreatment(@PathVariable long id) throws DoesNotExistTreatmentException {	
		 front.removeTreatment(id);
		 return "tratamento deletado!";
	}
}