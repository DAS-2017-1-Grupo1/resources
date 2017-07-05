package br.unb.fga.das.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Resource {
	private String name;
	private String description;
	private Long patrimonyCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPatrimonyCode() {
		return patrimonyCode;
	}

	public void setPatrimonyCode(Long patrimonyCode) {
		this.patrimonyCode = patrimonyCode;
	}

}
