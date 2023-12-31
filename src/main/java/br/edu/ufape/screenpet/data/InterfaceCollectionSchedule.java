package br.edu.ufape.screenpet.data;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Schedule;

@Repository
public interface InterfaceCollectionSchedule extends JpaRepository<Schedule, Long> {
	Schedule findByDate(Date date);
}