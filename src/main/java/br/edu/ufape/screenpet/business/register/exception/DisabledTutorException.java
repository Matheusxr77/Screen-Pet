package br.edu.ufape.screenpet.business.register.exception;

public class DisabledTutorException extends Exception {
	private static final long serialVersionUID = 1L;
	private boolean active;
	
	public DisabledTutorException(boolean active) {
		super("Não é possível desativar um Tutor que já está desativado!");
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}

}
