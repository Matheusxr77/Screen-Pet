package br.edu.ufape.screenpet.business.register.exception;

public class DuplicateUserException extends Exception {
	private static final long serialVersionUID = 1L;
	private String email;
	
	public DuplicateUserException(String email) {
		super("Não é possível cadastrar dois usuários com o mesmo email!");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}