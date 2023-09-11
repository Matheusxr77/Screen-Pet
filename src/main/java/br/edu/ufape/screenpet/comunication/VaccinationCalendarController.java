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

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.front.Front;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationCalendarException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationCalendarException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v11")
public class VaccinationCalendarController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/listar-calendarios-de-vacinacao")
	public List<VaccinationCalendar> listVaccinationCalendar() {
		return front.listVaccinationCalendar();
	}
	
	@PostMapping("/cadastrar-calendario-de-vacinacao")
	public VaccinationCalendar registerVaccinationCalendar(@RequestBody VaccinationCalendar vaccinationCalendar) throws DuplicateVaccinationCalendarException, DoesNotExistVaccinationCalendarException {
		return front.saveVaccinationCalendar(vaccinationCalendar);
	}
	
	@GetMapping("/pesquisar-calendario-de-vacinacao/{id}")
	public VaccinationCalendar printVaccinationCalendar(@PathVariable long id) {
		return front.findVaccinationCalendarId(id);
	}

	@PatchMapping("/editar-calendario-de-vacinacao/{id}")
	public VaccinationCalendar updateVaccinationCalendar(@PathVariable long id, @RequestBody VaccinationCalendar vaccinationCalendar) throws DuplicateVaccinationCalendarException, DoesNotExistVaccinationCalendarException {
		vaccinationCalendar.setId(id);
		return front.saveVaccinationCalendar(vaccinationCalendar);
	}
	
	@DeleteMapping("/deletar-calendario-de-vacinacao/{id}")
	public String deleteVaccinationCalendar(@PathVariable long id) throws DoesNotExistVaccinationCalendarException {	
		 front.removeVaccinationCalendar(id);
		 return "calendário de vacinação deletado!";
	}
}