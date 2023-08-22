package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.register.exception.VaccinationCalendarDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.VaccinationCalendarNotExistsException;
import br.edu.ufape.screenpet.data.InterfaceCollectionVaccinationCalendar;

@Service
public class RegisterVaccinationCalendar implements InterfaceRegisterVaccinationCalendar{
	@Autowired
private InterfaceCollectionVaccinationCalendar collectionVaccinationCalendar;

	
	public VaccinationCalendar findVaccinationCalendar(Date date) throws VaccinationCalendarNotExistsException {
		VaccinationCalendar vc = collectionVaccinationCalendar.findVaccinationCalendar(date); 
		if(vc == null) {
			throw new VaccinationCalendarNotExistsException(date);
		}
		return vc;
	}
	
	public VaccinationCalendar saveVaccinationCalendar(VaccinationCalendar entity) {
		try {
			findVaccinationCalendar(entity.getDate());
			throw new VaccinationCalendarDuplicateException(entity.getDate());
		} catch(VaccinationCalendarNotExistsException | VaccinationCalendarDuplicateException err) {
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

	public void removeSchedule(Date date) throws VaccinationCalendarNotExistsException {
		VaccinationCalendar vc = findVaccinationCalendar(date);
		collectionVaccinationCalendar.delete(vc);
	}

	@Override
	public void removeVaccinationCalendar(Date date) throws VaccinationCalendarNotExistsException {
		// TODO Auto-generated method stub
		
	}



}
