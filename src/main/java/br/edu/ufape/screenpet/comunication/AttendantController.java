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

import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAttendantException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2")
public class AttendantController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/listar-atendentes")
	public List<Attendant> listAttendant() {
		return front.listAttendant();
	}
	
	@PostMapping("/cadastrar-atendente")
	public Attendant registerAttendant(@RequestBody Attendant attendant) throws DuplicateAttendantException, DoesNotExistAttendantException {
		return front.saveAttendant(attendant);
	}
	
	@GetMapping("/pesquisar-atendente/{id}")
	public Attendant printAttendant(@PathVariable long id) {
		return front.findAttendantId(id);
	}
	
	@PatchMapping("/editar-atendente/{id}")
	public Attendant updateAttendant(@PathVariable long id, @RequestBody Attendant attendant) throws DuplicateAttendantException, DoesNotExistAttendantException {
		attendant.setId(id);
		return front.saveAttendant(attendant);
	}
	
	@DeleteMapping("/deletar-atendente/{id}")
	public String deleteAttendant(@PathVariable String cpf) throws DoesNotExistAttendantException {	
		 front.removeAttendant(cpf);
		 return "atendente deletado!";
	}
}