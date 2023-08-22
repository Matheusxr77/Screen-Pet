package br.edu.ufape.screenpet.business.register.exception;

import br.edu.ufape.screenpet.business.basic.Diagnosis;

public class DuplicateTreatmentException extends Exception {
	private static final long serialVersionUID = 1L;
	private Diagnosis diagnosis;
	
	public DuplicateTreatmentException(Diagnosis diagnosis) {
		super("Não é possível cadastrar dois tratamentos iguais para o mesmo diagnóstico!");
		this.diagnosis = diagnosis;
	}
	
	public Diagnosis getDiagnosis() {
		return this.diagnosis;
	}
}