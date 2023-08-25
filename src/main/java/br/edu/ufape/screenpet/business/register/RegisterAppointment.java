package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionAppointment;
import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAppointmentException;

@Service
public class RegisterAppointment implements InterfaceRegisterAppointment {
	@Autowired
	private InterfaceCollectionAppointment collectionAppointment;
	
	public Appointment findAppointment(Date date) throws DoesNotExistAppointmentException {
		Appointment appointment = collectionAppointment.findByDate(date); 
		if(appointment == null) {
			throw new DoesNotExistAppointmentException(date);
		}
		return appointment;
	}
	
	public Appointment saveAppointment(Appointment entity) throws DoesNotExistAppointmentException, DuplicateAppointmentException {
		try {
			findAppointment(entity.getDate());
			throw new DuplicateAppointmentException(entity.getDate());
		} catch(DoesNotExistAppointmentException err) {
			return collectionAppointment.save(entity);
		}
	}

	public List<Appointment> listAppointments() {
		return collectionAppointment.findAll();
	}

	public boolean checkExistenceAppointmentId(Long id) {
		return collectionAppointment.existsById(id);
	}

	public Appointment findAppointmentId(Long id) {
		return collectionAppointment.findById(id).orElse(null);
	}
}