package br.edu.ufape.screenpet.data;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@Repository
public interface InterfaceCollectionVaccinationCalendar extends JpaRepository<VaccinationCalendar, Long> {
<<<<<<< HEAD

	VaccinationCalendar findVaccinationCalendar(Date date);

}
=======
	VaccinationCalendar findByVaccinationCalendar(Date date);
}
>>>>>>> b392f2a093b88cd011508c9d62a8018a0aad363e
