package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.data.InterfaceCollectionSchedule;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.register.exception.ScheduleDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.ScheduleNotExistsException;

@Service
public class RegisterSchedule implements InterfaceRegisterSchedule {
	@Autowired
	private InterfaceCollectionSchedule collectionSchedule;

	public Schedule findSchedule(Date date) throws ScheduleNotExistsException {
		Schedule s = collectionSchedule.findByDate(date); 
		if(s == null) {
			throw new ScheduleNotExistsException(date);
		}
		return s;
	}
	
	public Schedule saveSchedule(Schedule entity)throws ScheduleNotExistsException, ScheduleDuplicateException {
		try {
			findSchedule(entity.getDate());
			throw new ScheduleDuplicateException(entity.getDate());
		} catch(ScheduleNotExistsException err) {
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

	public void removeSchedule(Date date) throws ScheduleNotExistsException {
		Schedule s = findSchedule(date);
		collectionSchedule.delete(s);
	}	
}