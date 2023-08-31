package br.edu.ufape.screenpet.comunication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistDiagnosisException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateDiagnosisException;

@RestController
@RequestMapping("/api/v14")
public class DiagnosisController {
	@Autowired
	public Front front;
	
	@GetMapping("/diagnostico")
	public List<Diagnosis> listDiagnosis() {
		return front.listDiagnosis();
	}
	
	@PostMapping("/diagnostico")
	public Diagnosis registerDiagnosis(@RequestBody Diagnosis diagnosis) throws DuplicateDiagnosisException, DoesNotExistDiagnosisException {
		return front.saveDiagnosis(diagnosis);
	}
	
	@GetMapping("/diagnostico/{id}")
	public Diagnosis printDiagnosis(@PathVariable long id) {
		return front.findDiagnosisId(id);
	}
}