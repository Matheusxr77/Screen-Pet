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

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationHistoricException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationHistoricException;

@RestController
@RequestMapping("/api/v12")
public class VaccinationHistoricController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/historico-de-vacinacao")
	public List<VaccinationHistoric> listVaccinationHistorics() {
		return front.listVaccinationHistorics();
	}
	
	@PostMapping("/historico-de-vacinacao")
	public VaccinationHistoric registerVaccinationHistoric(@RequestBody VaccinationHistoric vaccinationHistoric) throws DuplicateVaccinationHistoricException, DoesNotExistVaccinationHistoricException {
		return front.saveVaccinationHistoric(vaccinationHistoric);
	}
	
	@GetMapping("/historico-de-vacinacao/{id}")
	public VaccinationHistoric printVaccinationHistoric(@PathVariable long id) {
		return front.findVaccinationHistoricId(id);
	}
	
	@PatchMapping("/historico-de-vacinacao/{id}")
	public VaccinationHistoric updateVaccinationHistoric(@PathVariable VaccinationCalendar vaccinationCalendar, @RequestBody VaccinationHistoric vaccinationHistoric) throws DuplicateVaccinationHistoricException, DoesNotExistVaccinationHistoricException {
		vaccinationHistoric.setVaccinationCalendar(vaccinationCalendar);
		return front.saveVaccinationHistoric(vaccinationHistoric);
	}
	
	@DeleteMapping("/historico-de-vacinacao/{id}")
	public String deleteVaccinationHistoric(@PathVariable long id) throws DoesNotExistVaccinationHistoricException {	
		 front.removeVaccinationHistoric(id);
		 return "histórico de vacinação deletado!";
	}
}