package br.edu.ufape.screenpet.data;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.screenpet.business.basic.Treatment;

@Repository
public interface InterfaceCollectionTreatment extends JpaRepository<Treatment, Long> {
	Treatment findByDate(Date date);
}