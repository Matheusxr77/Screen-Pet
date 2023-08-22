package br.edu.ufape.screenpet.business.register;

import java.util.Date;
import java.util.List;

import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.register.exception.ScheduleDuplicateException;
import br.edu.ufape.screenpet.business.register.exception.ScheduleNotExistsException;

public interface InterfaceRegisterSchedule {
	Schedule findSchedule(Date date) throws ScheduleNotExistsException;
	Schedule saveSchedule(Schedule entity)throws ScheduleNotExistsException, ScheduleDuplicateException;
	List<Schedule> listSchedules();
	boolean checkExistenceScheduleId(Long id);
	Schedule findScheduleId(Long id);
	void removeSchedule(Date date) throws ScheduleNotExistsException;
}