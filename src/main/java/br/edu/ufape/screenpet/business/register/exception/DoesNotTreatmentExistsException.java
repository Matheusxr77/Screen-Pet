package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Diagnosis;

public class DoesNotTreatmentExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private Diagnosis diagnosis;
	
	public DoesNotTreatmentExistsException(Diagnosis diagnosis) {
		super("Não existe Pet no sistema que possua esse registro de vacina em seu calendário");
		this.diagnosis = diagnosis;
	}
	
	public Diagnosis getDiagnosis() {
		return this.diagnosis;
	}
}