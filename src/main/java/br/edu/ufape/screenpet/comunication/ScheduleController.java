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

import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistScheduleException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateScheduleException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@RequestMapping("/api/v7")
public class ScheduleController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/listar-agendamentos")
	public List<Schedule> listSchedules() {
		return front.listSchedules();
	}
	
	@PostMapping("/cadastrar-agendamento")
	public Schedule registerSchedule(@RequestBody Schedule schedule) throws DuplicateScheduleException, DoesNotExistScheduleException {
		return front.saveSchedule(schedule);
	}
	
	@GetMapping("/pesquisar-agendamento/{id}")
	public Schedule printSchedule(@PathVariable long id) {
		return front.findScheduleId(id);
	}
	
	@PatchMapping("/editar/agendamento/{id}")
	public Schedule updateSchedule(@PathVariable long id, @RequestBody Schedule schedule) throws DuplicateScheduleException, DoesNotExistScheduleException {
		schedule.setId(id);
		return front.saveSchedule(schedule);
	}
	
	@DeleteMapping("/deletar-agendamento/{id}")
	public String deleteSchedule(@PathVariable long id) throws DoesNotExistScheduleException {	
		 front.removeSchedule(id);
		 return "agendamento deletado!";
	}
}