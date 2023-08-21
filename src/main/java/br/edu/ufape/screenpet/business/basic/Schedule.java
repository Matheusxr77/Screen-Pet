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
import jakarta.persistence.OneToMany;

@Entity
public class Schedule {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private int time;
    private String type;
    private Date date;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Deworming> dewormings;
    
    @ManyToMany
    @Cascade(CascadeType.ALL)
    private List<Veterinarian> veterinarians;

    public List<Deworming> getDewormings() {
		return dewormings;
	}

	public void setDewormings(List<Deworming> dewormings) {
		this.dewormings = dewormings;
	}

	public List<Veterinarian> getVeterinarians() {
		return veterinarians;
	}

	public void setVeterinarians(List<Veterinarian> veterinarians) {
		this.veterinarians = veterinarians;
	}

	public int getTime() {
        return time;
    }

    public void setTime(int time) {
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

	public Schedule(long id, int time, String type, Date date, List<Deworming> dewormings,
			List<Veterinarian> veterinarians) {
		super();
		this.id = id;
		this.time = time;
		this.type = type;
		this.date = date;
		this.dewormings = dewormings;
		this.veterinarians = new ArrayList<>();
	}
}