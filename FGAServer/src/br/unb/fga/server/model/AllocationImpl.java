package br.unb.fga.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.unb.fga.das.model.Allocation;

@Entity
public class AllocationImpl extends Allocation {
	@Id
	@GeneratedValue
	private Long id;
	private String registration;
	private Long patrimonyCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Long getPatrimonyCode() {
		return patrimonyCode;
	}

	public void setPatrimonyCode(Long patrimonyCode) {
		this.patrimonyCode = patrimonyCode;
	}

}