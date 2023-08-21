package br.edu.ufape.screenpet.business.register.exception;

public class UserNotExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String email;
	
	public UserNotExistsException(String email) {
		super("Não existe no sistema um usuário com o email informado");
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
