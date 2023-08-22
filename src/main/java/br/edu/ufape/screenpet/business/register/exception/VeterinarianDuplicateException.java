package br.edu.ufape.screenpet.business.register.exception;

public class VeterinarianDuplicateException extends Exception{
	private static final long serialVersionUID = 1L;
	private int crmv;
	
	public VeterinarianDuplicateException(int crmv) {
		super("Veterinário já cadastrado no sistema.");
		this.crmv = crmv;
	}
	
	public int getCrmv() {
		return this.crmv;
	}
}
