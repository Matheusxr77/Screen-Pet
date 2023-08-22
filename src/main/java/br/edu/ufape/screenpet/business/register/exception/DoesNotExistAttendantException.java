package br.edu.ufape.screenpet.business.register.exception;

public class DoesNotExistAttendantException extends Exception {
	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public DoesNotExistAttendantException(String cpf) {
		super("Não existe no sistema um atendente com esse CPF!");
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
}