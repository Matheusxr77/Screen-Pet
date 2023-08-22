package br.edu.ufape.screenpet.data;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Medicament;

@Repository
public interface InterfaceCollectionAppointment extends JpaRepository<Appointment, Long>{
	
	Appointment findByDate(Date date);

}
