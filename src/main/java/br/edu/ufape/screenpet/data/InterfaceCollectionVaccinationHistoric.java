package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;

@Repository
public interface InterfaceCollectionVaccinationHistoric extends JpaRepository<VaccinationHistoric, Long> {

	VaccinationHistoric findByVaccinationCalendar(VaccinationCalendar vaccinationCalendar);

}
