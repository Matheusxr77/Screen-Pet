package br.edu.ufape.screenpet.business.basic;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Exam {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String laboratory;
    private Date date;
    private String type;
    private String comments;
    
    @ManyToOne
	@Cascade(CascadeType.ALL)
    private Pet pet;

	public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Exam(String laboratory, Date date, String type, String comments) {
		this.laboratory = laboratory;
		this.date = date;
		this.type = type;
		this.comments = comments;
	}
	
	public Exam() {

	}
}