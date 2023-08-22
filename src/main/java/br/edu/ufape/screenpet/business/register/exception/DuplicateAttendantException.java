package br.edu.ufape.screenpet.business.register.exception;

public class DuplicateAttendantException extends Exception {
	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public DuplicateAttendantException(String cpf) {
		super("Não é possível cadastrar dois atendentes com o mesmo CPF.");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
}