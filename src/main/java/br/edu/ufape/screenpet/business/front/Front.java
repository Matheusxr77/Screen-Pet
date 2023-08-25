package br.edu.ufape.screenpet.business.front;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Attendant;
import br.edu.ufape.screenpet.business.basic.Medicament;
import br.edu.ufape.screenpet.business.basic.Pet;
import br.edu.ufape.screenpet.business.basic.Schedule;
import br.edu.ufape.screenpet.business.basic.Treatment;
import br.edu.ufape.screenpet.business.basic.Tutor;
import br.edu.ufape.screenpet.business.basic.Usuario;
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
import br.edu.ufape.screenpet.business.register.InterfaceRegisterUsuario;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVaccinationCalendar;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVaccinationHistoric;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVaccine;
import br.edu.ufape.screenpet.business.register.InterfaceRegisterVeterinarian;
import br.edu.ufape.screenpet.business.register.exception.DisabledAttendantException;
import br.edu.ufape.screenpet.business.register.exception.DisabledPetException;
import br.edu.ufape.screenpet.business.register.exception.DisabledTutorException;
import br.edu.ufape.screenpet.business.register.exception.DisabledUserException;
import br.edu.ufape.screenpet.business.register.exception.DisabledVeterinarianException;
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
import br.edu.ufape.screenpet.business.register.exception.DuplicateScheduleException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTreatmentException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateTutorException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateUserException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationCalendarException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccinationHistoricException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVaccineException;
import br.edu.ufape.screenpet.business.register.exception.DuplicateVeterinarianException;

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
	private InterfaceRegisterUsuario registerUsuario;
	
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
	
	public List<Attendant> listAttendant() {
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
	
	public Schedule saveSchedule(Schedule entity)throws DoesNotExistScheduleException, DuplicateScheduleException {
		return registerSchedule.saveSchedule(entity);
	}
	
	public List<Schedule> listSchedules() {
		return registerSchedule.listSchedules();
	}
	
	public boolean checkExistenceScheduleId(Long id) {
		return registerSchedule.checkExistenceScheduleId(id);
	}
	
	public Schedule findScheduleId(Long id) {
		return registerSchedule.findScheduleId(id);
	}
	
	public void removeSchedule(Long id) throws DoesNotExistScheduleException {
		registerSchedule.removeSchedule(id);
	}

	public Treatment findTreatment(Date date) throws DoesNotExistTreatmentException {
		return registerTreatment.findTreatment(date);
	}
	
	public Treatment saveTreatment(Treatment entity) throws DoesNotExistTreatmentException, DuplicateTreatmentException {
		return registerTreatment.saveTreatment(entity);
	}
	
	public List<Treatment> listTreatments() {
		return registerTreatment.listTreatments();
	}
	
	public boolean checkExistenceTreatmentId(Long id) {
		return registerTreatment.checkExistenceTreatmentId(id);
	}
	
	public Treatment findTreatmentId(Long id) {
		return registerTreatment.findTreatmentId(id);
	}

	public Tutor findTutorCpf(String cpf) throws DoesNotExistTutorException {
		return registerTutor.findTutorCpf(cpf);
	}
	
	public Tutor saveTutor(Tutor entity) throws DuplicateTutorException {
		return registerTutor.saveTutor(entity);
	}
	
	public Tutor updateTutor(Tutor entity) throws DoesNotExistTutorException {
		return registerTutor.updateTutor(entity);
	}
	
	public List<Tutor> listTutor() {
		return registerTutor.listTutor();
	}
	
	public boolean checkTutorExistence(Long id) {
		return registerTutor.checkTutorExistence(id);
	}
	
	public Tutor findTutorId(Long id) {
		return registerTutor.findTutorId(id);
	}
	
	public void deactivateTutor(String cpf) throws DoesNotExistTutorException, DisabledTutorException {
		registerTutor.deactivateTutor(cpf);
	}

	public Usuario findUsuarioEmail(String email) throws DoesNotExistUserException {
		return registerUsuario.findUsuarioEmail(email);
	}
	
	public Usuario saveUsuario(Usuario entity) throws DuplicateUserException {
		return registerUsuario.saveUsuario(entity);
	}
	
	public List<Usuario> listUsuarios() {
		return registerUsuario.listUsuarios();
	}
	
	public boolean checkUsuarioExistence(Long id) {
		return registerUsuario.checkUsuarioExistence(id);
	}
	
	public Usuario findUsuarioId(Long id) {
		return registerUsuario.findUsuarioId(id);
	}
	
	public void deactivateUsuario(Long id) throws DoesNotExistUserException, DisabledUserException {
		registerUsuario.deactivateUsuario(id);
	}

	public VaccinationCalendar findVaccinationCalendar(Date date) throws DoesNotExistVaccinationCalendarException {
		return registerVaccinationCalendar.findVaccinationCalendar(date);
	}
	
	public VaccinationCalendar saveVaccinationCalendar(VaccinationCalendar entity) throws DuplicateVaccinationCalendarException, DoesNotExistVaccinationCalendarException {
		return registerVaccinationCalendar.saveVaccinationCalendar(entity);
	}
	
	public List<VaccinationCalendar> listVaccinationCalendar() {
		return registerVaccinationCalendar.listVaccinationCalendar();
	}
	
	public boolean checkExistenceVaccinationCalendarId(Long id) {
		return registerVaccinationCalendar.checkExistenceVaccinationCalendarId(id);
	}
	
	public VaccinationCalendar findVaccinationCalendarId(Long id) {
		return registerVaccinationCalendar.findVaccinationCalendarId(id);
	}
	
	public VaccinationHistoric findVaccinationHistoric(VaccinationCalendar vaccinationCalendar) throws DoesNotExistVaccinationHistoricException {
		return registerVaccinationHistoric.findVaccinationHistoric(vaccinationCalendar);
	}
	
	public VaccinationHistoric saveVaccinationHistoric(VaccinationHistoric entity)throws DoesNotExistVaccinationHistoricException, DuplicateVaccinationHistoricException {
		return registerVaccinationHistoric.saveVaccinationHistoric(entity);
	}
	
	public List<VaccinationHistoric> listVaccinationHistorics() {
		return registerVaccinationHistoric.listVaccinationHistorics();
	}
	
	public boolean checkExistenceVaccinationHistoricId(Long id) {
		return registerVaccinationHistoric.checkExistenceVaccinationHistoricId(id);
	}
	
	public VaccinationHistoric findVaccinationHistoricId(Long id) {
		return registerVaccinationHistoric.findVaccinationHistoricId(id);
	}
	
	public Vaccine findVaccine(String name) throws DoesNotExistVaccineException {
		return registerVaccine.findVaccine(name);
	}
	
	public Vaccine saveVaccine(Vaccine entity) throws DuplicateVaccineException, DoesNotExistVaccineException {
		return registerVaccine.saveVaccine(entity);
	}
	
	public List<Vaccine> listVaccines() {
		return registerVaccine.listVaccines();
	}
	
	public boolean checkExistenceVaccineId(Long id) {
		return registerVaccine.checkExistenceVaccineId(id);
	}

	public Vaccine findVaccineId(Long id) {
		return registerVaccine.findVaccineId(id);
	}
	
	public void removeVaccine(Long id) throws DoesNotExistVaccineException {
		registerVaccine.removeVaccine(id);
	}

	public Veterinarian findByCrmv(int crmv) throws DoesNotExistVeterinarianException {
		return registerVeterinarian.findByCrmv(crmv);
	}
	
	public Veterinarian saveVeterinarian(Veterinarian entity) throws DuplicateVeterinarianException {
		return registerVeterinarian.saveVeterinarian(entity);
	}
	
	public Veterinarian updateVeterinarian(Veterinarian entity) throws DoesNotExistVeterinarianException {
		return registerVeterinarian.updateVeterinarian(entity);
	}
	
	public List<Veterinarian> listVeterinarian() {
		return registerVeterinarian.listVeterinarian();
	}
	
	public boolean checkVeterinarianExistence(Long id) {
		return registerVeterinarian.checkVeterinarianExistence(id);
	}
	
	public Veterinarian findVeterinarianId(Long id) {
		return registerVeterinarian.findVeterinarianId(id);
	}
	
	public void deactivateVeterinarian(int crmv) throws DoesNotExistVeterinarianException, DisabledVeterinarianException {
		registerVeterinarian.deactivateVeterinarian(crmv);
	}
}