package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.AppointmentDoesNotExistException;

public interface InterfaceRegisterAppointment {
	
	Appointment findAppointment(Date date) throws AppointmentDoesNotExistException;

	Appointment saveMedicament(Appointment entity) throws DuplicateAppointmentException, AppointmentDoesNotExistException;

	List<Appointment> listAppointments();

	boolean checkExistenceAppointmentId(Long id);

	Appointment findAppointmentId(Long id);
}
