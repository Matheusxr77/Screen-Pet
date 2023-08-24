package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionVaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationCalendarException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationCalendarException;

@Service
public class RegisterVaccinationCalendar implements InterfaceRegisterVaccinationCalendar {
	@Autowired
	private InterfaceCollectionVaccinationCalendar collectionVaccinationCalendar;
	
	public VaccinationCalendar findVaccinationCalendar(Date date) throws DoesNotExistVaccinationCalendarException {
		VaccinationCalendar vc = collectionVaccinationCalendar.findByVaccinationCalendar(date); 
		if(vc == null) {
			throw new DoesNotExistVaccinationCalendarException(date);
		}
		return vc;
	}
	
	public VaccinationCalendar saveVaccinationCalendar(VaccinationCalendar entity) throws DuplicateVaccinationCalendarException, DoesNotExistVaccinationCalendarException {
		try {
			findVaccinationCalendar(entity.getDate());
			throw new DuplicateVaccinationCalendarException(entity.getDate());
		} catch(DoesNotExistVaccinationCalendarException err) {
			return collectionVaccinationCalendar.save(entity);
		}
	}

	public List<VaccinationCalendar> listVaccinationCalendar() {
		return collectionVaccinationCalendar.findAll();
	}

	public boolean checkExistenceVaccinationCalendarId(Long id) {
		return collectionVaccinationCalendar.existsById(id);
	}

	public VaccinationCalendar findVaccinationCalendarId(Long id) {
		return collectionVaccinationCalendar.findById(id).orElse(null);
	}
}