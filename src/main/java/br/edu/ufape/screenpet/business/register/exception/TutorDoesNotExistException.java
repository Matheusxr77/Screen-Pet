package br.edu.ufape.screenpet.business.register.exception;

public class TutorDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public TutorDoesNotExistException(String cpf) {
		super("Não existe no sistema um tutor com esse CPF.");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}

}
