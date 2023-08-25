package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private Date date;
    private String posology;
    private String comments;
    
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Diagnosis diagnosis;

	@ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Medicament> medicaments;
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Deworming deworming;
    
	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public Deworming getDeworming() {
		return deworming;
	}

	public void setDeworming(Deworming deworming) {
		this.deworming = deworming;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPosology() {
		return posology;
	}

	public void setPosology(String posology) {
		this.posology = posology;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Treatment(Date date, String posology, String comments, List<Medicament> medicaments, Deworming deworming) {
		super();
		this.date = date;
		this.posology = posology;
		this.comments = comments;
		this.deworming = deworming;
		this.medicaments = new ArrayList<>();
	}
}