package br.edu.ufape.screenpet.business.register.exception;

public class DuplicateVeterinarianException extends Exception {
	private static final long serialVersionUID = 1L;
	private int crmv;
	
	public DuplicateVeterinarianException(int crmv) {
		super("Não é possível cadastrar dois veterinários com o mesmo crmv no sistema!");
		this.crmv = crmv;
	}
	
	public int getCrmv() {
		return this.crmv;
	}
}