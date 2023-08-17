package br.edu.ufape.screenpet.business.basic;

import jakarta.persistence.Entity;

@Entity
public class Veterinarian extends Person {
    private int crmv;
    
    public Veterinarian() {
    	
    }

    public int getCrmv() {
        return crmv;
    }

    public void setCrmv(int crmv) {
        this.crmv = crmv;
    }
}
