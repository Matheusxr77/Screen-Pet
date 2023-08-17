package br.edu.ufape.screenpet.business.basic;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exam {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String laboratory;
    private Date date;
    private String type;
    private String comments;

    public Exam(long id, String laboratory, Date date, String type, String comments) {
        super();
        this.setLaboratory(laboratory);
        this.setDate(date);
        this.setType(type);
        this.setComments(comments);
    }

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
}
