package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@RequestMapping("/api/v5")
public class MedicamentController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/medicamento")
	public List<Medicament> listAttendant() {
		return front.listMedicaments();
	}
	
	@PostMapping("/medicamento")
	public Medicament registerAttendant(@RequestBody Medicament medicament) throws DuplicateMedicamentException, DoesNotExistMedicamentException {
		return front.saveMedicament(medicament);
	}
	
	@GetMapping("/medicamento/{id}")
	public Medicament printMedicament(@PathVariable long id) {
		return front.findMedicamentId(id);
	}
}