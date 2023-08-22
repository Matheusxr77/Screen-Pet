package br.edu.ufape.screenpet.data;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Schedule;

@Repository
<<<<<<< HEAD
public interface InterfaceCollectionSchedule extends JpaRepository<Schedule, Long> {

}
=======
public interface InterfaceCollectionSchedule extends JpaRepository<Schedule, Long>{
	Schedule findByDate(Date date);
}
>>>>>>> 23b36c63fd198b33ee39e7831af76136bc578590
