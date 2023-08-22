package br.edu.ufape.screenpet.business.register.exception;

public class VeterinarianNotExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	private int crmv;
	
	public VeterinarianNotExistsException(int crmv) {
		super("Não existe no sistema um veterinário com a CRMV informada.");
		this.crmv = crmv;
	}
	
	public int getCrmv() {
		return this.crmv;
	}
}
