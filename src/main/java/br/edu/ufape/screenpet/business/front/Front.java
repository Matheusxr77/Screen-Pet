package br.edu.ufape.screenpet.business.front;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.basic.Diagnosis;
import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.User;
import br.edu.ufape.screenpet.business.basic.VaccinationCalendar;
import br.edu.ufape.screenpet.business.basic.VaccinationHistoric;
import br.edu.ufape.screenpet.business.basic.Vaccine;
import br.edu.ufape.screenpet.business.basic.Veterinarian;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterAppointment;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterAttendant;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterMedicament;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterPet;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterSchedule;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterTreatment;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterTutor;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterUser;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVaccinationCalendar;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVaccinationHistoric;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVaccine;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVeterinarian;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistPetException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistScheduleException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTreatmentException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistTutorException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistUserException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationCalendarException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccinationHistoricException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVaccineException;
import br.edu.ufape.screenpet.business.register.exception.DoesNotExistVeterinarianException;

@Service
public class Front {
	
	@Autowired
	private InterfaceRegisterAppointment registerAppointment;
	
	@Autowired
	private InterfaceRegisterAttendant registerAttendant;
	
	@Autowired
	private InterfaceRegisterMedicament registerMedicament;
	
	@Autowired
	private InterfaceRegisterPet registerPet;
	
	@Autowired
	private InterfaceRegisterSchedule registerSchedule;
	
	@Autowired
	private InterfaceRegisterTreatment registerTreatment;
	
	@Autowired
	private InterfaceRegisterTutor registerTutor;
	
	@Autowired
	private InterfaceRegisterUser registerUser;
	
	@Autowired
	private InterfaceRegisterVaccinationCalendar registerVaccinationCalendar;
	
	@Autowired
	private InterfaceRegisterVaccinationHistoric registerVaccinationHistoric;
	
	@Autowired
	private InterfaceRegisterVaccine registerVaccine;
	
	@Autowired
	private InterfaceRegisterVeterinarian registerVeterinarian;
	
	public Appointment findAppointment(Date date) throws DoesNotExistAppointmentException {
		return registerAppointment.findAppointment(date);
	}
	
	public Attendant findAttendantCpf(String cpf) throws DoesNotExistAttendantException {
		return registerAttendant.findAttendantCpf(cpf);
	}
	
	public Medicament findMedicament(String activeCompound) throws DoesNotExistMedicamentException {
		return registerMedicament.findMedicament(activeCompound);
	}
	
	public Pet findPetName(String name) throws DoesNotExistPetException {
		return registerPet.findPetName(name);
	}
	
	public Schedule findSchedule(Date date) throws DoesNotExistScheduleException {
		return registerSchedule.findSchedule(date);
	}
	
	public Treatment findTreatment(Diagnosis diagnosis) throws DoesNotExistTreatmentException {
		return registerTreatment.findTreatment(diagnosis);
	}
	
	public Tutor findTutorCpf(String cpf) throws DoesNotExistTutorException {
		return registerTutor.findTutorCpf(cpf);
	}
	
	public User findUserEmail(String email) throws DoesNotExistUserException {
		return registerUser.findUserEmail(email);
	}
	
	public VaccinationCalendar findVaccinationCalendar(Date date) throws DoesNotExistVaccinationCalendarException {
		return registerVaccinationCalendar.findVaccinationCalendar(date);
	}
	
	public VaccinationHistoric findVaccinationHistoric(VaccinationCalendar vaccinationCalendar) throws DoesNotExistVaccinationHistoricException {
		return registerVaccinationHistoric.findVaccinationHistoric(vaccinationCalendar);
	}
	
	public Vaccine findVaccine(String name) throws DoesNotExistVaccineException {
		return registerVaccine.findVaccine(name);
	}
	
	public Veterinarian findByCrmv(int crmv) throws DoesNotExistVeterinarianException {
		return registerVeterinarian.findByCrmv(crmv);
	}
}