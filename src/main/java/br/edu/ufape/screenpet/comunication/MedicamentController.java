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

import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistMedicamentException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v5")
public class MedicamentController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/listar-medicamentos")
	public List<Medicament> listAttendant() {
		return front.listMedicaments();
	}
	
	@PostMapping("/cadastrar-medicamento")
	public Medicament registerAttendant(@RequestBody Medicament medicament) throws DoesNotExistMedicamentException {
		return front.saveMedicament(medicament);
	}
	
	@GetMapping("/pesquisar-medicamento/{id}")
	public Medicament printMedicament(@PathVariable long id) {
		return front.findMedicamentId(id);
	}
	
	@PatchMapping("/editar-medicamento/{id}")
	public Medicament updateMedicament(@PathVariable long id, @RequestBody Medicament medicament) throws DoesNotExistMedicamentException {
		medicament.setId(id);
		return front.saveMedicament(medicament);
	}
	
	@DeleteMapping("/deletar-medicamento/{id}")
	public String deleteMedicament(@PathVariable long id) throws DoesNotExistMedicamentException {	
		 front.removeMedicament(id);
		 return "medicamento deletado!";
	}
}