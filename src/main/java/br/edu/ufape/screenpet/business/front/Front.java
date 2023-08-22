package br.edu.ufape.screenpet.business.front;

import java.util.Date;
import java.util.List;

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
import br.edu.ufape.screenpet.business.register.exception.DisabledAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DisabledPetException;
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
import br.edu.ufape.screenpet.business.register.exception.DuplicateAppointmentException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateMedicamentException;
import br.edu.ufape.screenpet.business.register.exception.DuplicatePetException;

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
	
	public Appointment saveAppointment(Appointment entity) throws DuplicateAppointmentException, DoesNotExistAppointmentException {
		return registerAppointment.saveAppointment(entity);
	}
	
	public List<Appointment> listAppointments() {
		return registerAppointment.listAppointments();
	}
	
	public boolean checkExistenceAppointmentId(Long id) {
		return registerAppointment.checkExistenceAppointmentId(id);
	}
	
	public Appointment findAppointmentId(Long id) {
		return registerAppointment.findAppointmentId(id);
	}
	
	public Attendant findAttendantCpf(String cpf) throws DoesNotExistAttendantException {
		return registerAttendant.findAttendantCpf(cpf);
	}
	
	public 	Attendant saveAttendant(Attendant entity) throws DuplicateAttendantException {
		return registerAttendant.saveAttendant(entity);
	}
	
	public 	Attendant updateAttendant(Attendant entity) throws DoesNotExistAttendantException {
		return registerAttendant.updateAttendant(entity);
	}
	
	public List<Attendant> listAttendant(){
		return registerAttendant.listAttendant();
	}
	
	public boolean checkAttendantExistence(Long id) {
		return registerAttendant.checkAttendantExistence(id);
	}
	
	public Attendant findAttendantId(Long id) {
		return registerAttendant.findAttendantId(id);
	}
	
	public void deactivateAttendant(String cpf) throws DoesNotExistAttendantException, DisabledAttendantException {
		registerAttendant.deactivateAttendant(cpf);
	}
	
	public Medicament findMedicament(String activeCompound) throws DoesNotExistMedicamentException {
		return registerMedicament.findMedicament(activeCompound);
	}
	
	public Medicament saveMedicament(Medicament entity) throws DuplicateMedicamentException, DoesNotExistMedicamentException {
		return registerMedicament.saveMedicament(entity);
	}
	
	public List<Medicament> listMedicaments() {
		return registerMedicament.listMedicaments();
	}
	
	public boolean checkExistenceMedicamentId(Long id) {
		return registerMedicament.checkExistenceMedicamentId(id);
	}
	
	public Medicament findMedicamentId(Long id) {
		return registerMedicament.findMedicamentId(id);
	}
	
	void removeMedicament(Long id) throws DoesNotExistMedicamentException {
		registerMedicament.removeMedicament(id);
	}
	public Pet findPetName(String name) throws DoesNotExistPetException {
		return registerPet.findPetName(name);
	}
	
	public Pet savePet(Pet entity) throws DuplicatePetException {
		return registerPet.savePet(entity);
	}
	
	public Pet updatePet(Pet entity) throws DoesNotExistPetException {
		return registerPet.updatePet(entity);
	}
	
	public List<Pet> listPets() {
		return registerPet.listPets();
	}
	
	public boolean checkPetExistence(Long id) {
		return registerPet.checkPetExistence(id);
	}
	
	public Pet findPetId(Long id) {
		return registerPet.findPetId(id);
	}
	
	public void deactivatePet(Long id) throws DoesNotExistPetException, DisabledPetException {
		registerPet.deactivatePet(id);
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