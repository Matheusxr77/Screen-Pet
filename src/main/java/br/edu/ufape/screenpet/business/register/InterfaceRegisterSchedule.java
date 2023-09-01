package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.register.exception.DuplicateScheduleException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistScheduleException;

public interface InterfaceRegisterSchedule {
	Schedule findSchedule(Date date) throws DoesNotExistScheduleException;
	Schedule saveSchedule(Schedule entity) throws DoesNotExistScheduleException, DuplicateScheduleException;
	List<Schedule> listSchedules();
	boolean checkExistenceScheduleId(Long id);
	Schedule findScheduleId(Long id);
	void removeSchedule(Long id) throws DoesNotExistScheduleException;
}