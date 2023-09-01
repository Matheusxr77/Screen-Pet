package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionSchedule;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.register.exception.DuplicateScheduleException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistScheduleException;

@Service
public class RegisterSchedule implements InterfaceRegisterSchedule {
	
	@Autowired
	private InterfaceCollectionSchedule collectionSchedule;

	public Schedule findSchedule(Date date) throws DoesNotExistScheduleException {
		Schedule schedule = collectionSchedule.findByDate(date); 
		if(schedule == null) {
			throw new DoesNotExistScheduleException(date);
		}
		return schedule;
	}
	
	public Schedule saveSchedule(Schedule entity) throws DoesNotExistScheduleException, DuplicateScheduleException {
		try {
			findSchedule(entity.getDate());
			throw new DuplicateScheduleException(entity.getDate());
		} catch(DoesNotExistScheduleException err) {
			return collectionSchedule.save(entity);
		}
	}

	public List<Schedule> listSchedules() {
		return collectionSchedule.findAll();
	}

	public boolean checkExistenceScheduleId(Long id) {
		return collectionSchedule.existsById(id);
	}

	public Schedule findScheduleId(Long id) {
		return collectionSchedule.findById(id).orElse(null);
	}

	public void removeSchedule(Long id) throws DoesNotExistScheduleException {
		Schedule schedule = findScheduleId(id);
		collectionSchedule.delete(schedule);
	}	
}