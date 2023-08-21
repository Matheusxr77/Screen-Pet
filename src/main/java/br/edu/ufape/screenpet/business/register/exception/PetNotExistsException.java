package br.edu.ufape.screenpet.business.register.exception;

public class PetNotExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public PetNotExistsException(String name) {
		super("Não existe no sistema um pet com o nome informado");
		this.name = name;
	}
	
	public String getname() {
		return this.name;
	}
}
