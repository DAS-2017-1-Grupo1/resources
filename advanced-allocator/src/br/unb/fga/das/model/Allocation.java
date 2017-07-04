package br.unb.fga.das.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Allocation {
	@Id
	@GeneratedValue
	private Long id;

	private Long patrimonyCode;
	private String registration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatrimonyCode() {
		return patrimonyCode;
	}

	public void setPatrimonyCode(Long patrimonyCode) {
		this.patrimonyCode = patrimonyCode;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

}
