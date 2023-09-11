package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTutorException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v9")
public class TutorController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/listar-tutores")
	public List<Tutor> listTutor() {
		return front.listTutor();
	}
	
	@PostMapping("/cadastrar-tutor")
	public Tutor registerTutor(@RequestBody Tutor tutor) throws DuplicateTutorException, DoesNotExistTutorException {
		return front.saveTutor(tutor);
	}
	
	@GetMapping("/tutor/{id}")
	public Tutor printTutor(@PathVariable long id) {
		return front.findTutorId(id);
	}
	
	@PatchMapping("/tutor/{cpf}")
	public Tutor updateTutor(@PathVariable String cpf, @RequestBody Tutor tutor) throws DuplicateTutorException, DoesNotExistTutorException {
		tutor.setCpf(cpf);
		return front.saveTutor(tutor);
	}
	
	@DeleteMapping("/tutor/{cpf}")
	public String deleteAttendant(@PathVariable String cpf) throws DoesNotExistTutorException {	
		 front.removeTutor(cpf);
		 return "tutor deletado!";
	}
}