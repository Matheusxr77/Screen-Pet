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

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAppointmentException;
import br.edu.ufape.screenpet.business.front.Front;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
	
	@Autowired
	public Front front;
	
	@GetMapping("/consulta")
	public List<Appointment> listAppointments() {
		return front.listAppointments();
	}
	
	@PostMapping("/consulta")
	public Appointment registerAppointment(@RequestBody Appointment appointment) throws DuplicateAppointmentException, DoesNotExistAppointmentException {
		return front.saveAppointment(appointment);
	}
	
	@GetMapping("/consulta/{id}")
	public Appointment printAppointment(@PathVariable long id) {
		return front.findAppointmentId(id);
	}	
	
	@PatchMapping("/consulta/{id}")
	public Appointment updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) throws DuplicateAppointmentException, DoesNotExistAppointmentException {
		appointment.setId(id);
		return front.saveAppointment(appointment);
	}
	
	@DeleteMapping("/consulta/{id}")
	public String deleteAppointment(@PathVariable long id) throws DoesNotExistAppointmentException {	
		 front.removeAppointment(id);
		 return "consulta deletada!";
	}
}