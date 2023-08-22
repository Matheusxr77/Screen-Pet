package br.edu.ufape.screenpet.business.register;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionVaccinationHistoric;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationHistoricException;
import br.edu.ufape.screenpet.business.register.exception.VaccinationHistoricDoesNotExistException;

@Service
public class RegisterVaccinationHistoric {
	@Autowired
	private InterfaceCollectionVaccinationHistoric collectionVaccinationHistoric;
	
	public VaccinationHistoric findVaccinationHistoric(VaccinationCalendar vaccinationCalendar) throws VaccinationHistoricDoesNotExistException {
		VaccinationHistoric vaccinationHistoric = collectionVaccinationHistoric.findByVaccinationCalendar(vaccinationCalendar); 
		if(vaccinationHistoric == null) {
			throw new VaccinationHistoricDoesNotExistException(vaccinationCalendar);
		}
		return vaccinationHistoric;
	}
	
	public VaccinationHistoric saveVaccinationHistoric(VaccinationHistoric entity)throws VaccinationHistoricDoesNotExistException, DuplicateVaccinationHistoricException {
		try {
			findVaccinationHistoric(entity.getVaccinationCalendar());
			throw new DuplicateVaccinationHistoricException(entity.getVaccinationCalendar());
		} catch(VaccinationHistoricDoesNotExistException err) {
			return collectionVaccinationHistoric.save(entity);
		}
	}

	public List<VaccinationHistoric> listVaccinationHistorics() {
		return collectionVaccinationHistoric.findAll();
	}

	public boolean checkExistenceVaccinationHistoricId(Long id) {
		return collectionVaccinationHistoric.existsById(id);
	}

	public VaccinationHistoric findVaccinationHistoricId(Long id) {
		return collectionVaccinationHistoric.findById(id).orElse(null);
	}
}