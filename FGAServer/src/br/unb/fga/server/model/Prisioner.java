package br.unb.fga.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.unb.fga.das.model.User;

@Entity
public class Prisioner extends User {

	@Id
	@GeneratedValue
	private Long id;
	private int sentenceTime;
	private String crime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSentenceTime() {
		return sentenceTime;
	}

	public void setSentenceTime(int sentenceTime) {
		this.sentenceTime = sentenceTime;
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}	
}
