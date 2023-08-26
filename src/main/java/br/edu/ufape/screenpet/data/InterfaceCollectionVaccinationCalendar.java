package br.edu.ufape.screenpet.data;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;

@Repository
public interface InterfaceCollectionVaccinationCalendar extends JpaRepository<VaccinationCalendar, Long> {
	VaccinationCalendar findByDate(Date date);
}