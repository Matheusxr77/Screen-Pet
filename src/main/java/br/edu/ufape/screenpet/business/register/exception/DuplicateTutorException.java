package br.edu.ufape.screenpet.business.register.exception;

public class DuplicateTutorException extends Exception {

	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public DuplicateTutorException(String cpf) {
		super("Não é possível cadastrar dois tutores com o mesmo CPF.");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}

}
