package br.edu.ufape.screenpet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceColecaoSchedule extends JpaRepository<Schedule, Long>{

}
