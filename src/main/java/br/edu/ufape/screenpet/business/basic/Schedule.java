package br.edu.ufape.screenpet.business.basic;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Schedule {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private Date time;
    private String type;
    private Date date;
    
    @OneToOne
	@Cascade(CascadeType.ALL)
    private Pet pet;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Schedule(Date time, String type, Date date) {
		this.time = time;
		this.type = type;
		this.date = date;
	}
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
}