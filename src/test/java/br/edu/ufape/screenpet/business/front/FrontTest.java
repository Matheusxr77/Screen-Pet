package br.edu.ufape.screenpet.business.front;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.basic.Usuario;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTutorException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVeterinarianException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class FrontTest {
	
	@Autowired
	private Front front;
	
	@BeforeEach
	public void initAppointment() throws DuplicateAppointmentException, DoesNotExistAppointmentException {
		Appointment appointment1 = new Appointment("consulta1", new Date());
		Appointment appointment2 = new Appointment("consulta2", new Date());
		
		front.saveAppointment(appointment1);
		front.saveAppointment(appointment2);
	}
	
	@BeforeEach
	public void initAttendant() throws DuplicateAttendantException, DoesNotExistAttendantException {
		Attendant attendant1 = new Attendant("atendente1", "12345678920", "feminino", new Date(), true);
		Attendant attendant2 = new Attendant("atendente2", "12345678940", "feminino", new Date(), true);
		
		front.saveAttendant(attendant1);
		front.saveAttendant(attendant2);
	}
	
	@BeforeEach
	public void initTutor() throws DuplicateTutorException, DoesNotExistTutorException {
		Tutor tutor1 = new Tutor("tutor1", "12345678910", "feminino", new Date(), true);
		Tutor tutor2 = new Tutor("tutor2", "12345678911", "masculino", new Date(), true);
		
		front.saveTutor(tutor1);
		front.saveTutor(tutor2);
	}
	
	@BeforeEach
	public void initUser() throws DuplicateUserException, DoesNotExistUserException {
		Usuario user1 = new Usuario("igor@gmail.com", "9875689");
		Usuario user2 = new Usuario("medeiros@gmail.com", "9875689");
		
		front.saveUsuario(user1);
		front.saveUsuario(user2);
	}	
	
	@BeforeEach
	public void initVeterinarian() throws DuplicateVeterinarianException, DoesNotExistVeterinarianException {
		Veterinarian veterinarian1 = new Veterinarian("veterinarian1", "12346678910", "feminino", new Date(), true, 1432);
		Veterinarian veterinarian2 = new Veterinarian("veterinarian2", "12347678911", "masculino", new Date(), true, 2345);
		
		front.saveVeterinarian(veterinarian1);
		front.saveVeterinarian(veterinarian2);
	}
}